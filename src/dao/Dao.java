package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import util.Util;

import model.User;

public class Dao {

	private Connection conn;

	public Dao(){
		conn = Util.getConnection();
		System.out.println("conn's value is - " + conn);
		if(conn != null){
			System.out.println("SO, conn has something");
		}
	}
	//called from doPost()
	public void addUser(User po){
		try {
			System.out.println("in addUser");
			String st = "insert into user(firstname,lastname,dob,email) values (?, ?, ?, ? )";
			PreparedStatement ps = conn.prepareStatement(st);
			System.out.println("after ps");
			ps.setString(1, po.getFirstName());
			ps.setString(2, po.getLastName());
			ps.setDate(3, new java.sql.Date(po.getDob().getTime()));
			ps.setString(4, po.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.toString();
		}
	}
	//from doGet
	public void deleteUser(int id){
		try {
			PreparedStatement ps = conn.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//from doGet
	//DEBUG THIS
	public void updateUser(User user) {
		try {
			System.out.println("in Update user");
			PreparedStatement ps = conn.prepareStatement("update user set firstname=?, lastname=?, dob=?, email=?" + "where id=?");
			System.out.println("after PS");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new Date(user.getDob().getTime()));
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getUserid());
			System.out.println("before execute");
			ps.executeUpdate();
			System.out.println("after execute");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers(){
		List<User> listOfPojo = new ArrayList<User>();
		try{
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from user");
			while(rs.next()){
				User po = new User();
				po.setUserid(rs.getInt("id"));
				po.setFirstName(rs.getString("firstname"));
				po.setLastName(rs.getString("lastname"));
				po.setDob(rs.getDate("dob"));
				po.setEmail(rs.getString("email"));
				listOfPojo.add(po);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listOfPojo;
	}

	public User getUserById(int id){
		User user = new User();
		try{
			PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user.setUserid(rs.getInt("id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
}//dao ends

