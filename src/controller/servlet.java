package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.Dao;

public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private Dao dao;

	public servlet(){
		dao = new Dao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		try{
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
			user.setDob(date);
		}catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		
		user.setEmail(request.getParameter("email"));
		String userId = request.getParameter("userId");
	//user id will be null or empty only @ fresh addition of profile
		if(userId == null||userId.isEmpty()){
			dao.addUser(user);
		}else{
			//this runs when we are trying to edit profile
			//since userid is String, it has to be parsed to int..
			user.setUserid(Integer.parseInt(userId));
			dao.updateUser(user);
		}
		request.setAttribute("users", dao.getAllUsers());
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		view.forward(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")){
			int userId = Integer.parseInt(request.getParameter("userId"));
			dao.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")){
			forward = INSERT_OR_EDIT;
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = dao.getUserById(userId);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")){
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);	
	}

}


