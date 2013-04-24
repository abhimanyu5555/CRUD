<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery-ui.min.js"></script>

<!-- css -->
<link href="crudStyle.css" rel="stylesheet" type="text/css">
<!-- bootstrap -->
<link href="bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="bootstrap.min.js"></script>
<!-- jstl uri -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
</head>
<body>
	<h2>Check DB</h2>
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>id</th>
				<th>firstname</th>
				<th>lastname</th>
				<th>dob</th>
				<th>email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<!-- here we loop -->
					<td><c:out value="${user.userid}"/></td>
					<td><c:out value="${user.firstName}"/></td>
					<td><c:out value="${user.lastName}"/></td>
					<td>
						<fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}"/>
					</td>
					<td><c:out value="${user.email}"/></td>
					<td>
					<div align="center">
						<a href="servlet?action=delete&userId=<c:out value="${user.userid}"/>" class="btn btn-primary">x</a>
					</div>
					</td>
					<td>
					<div align="center">
						<a href="servlet?action=edit&userId=<c:out value="${user.userid}"/>" class="btn btn-primary">edit</a>
					</div>
					</td>
					<%-- <td><a href="Edit_Servlet?userId=<c:out value="${user.userid}"/>" class="btn btn-primary">edit</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="right">
		<a href="http://localhost:8080/CRUD" class="btn btn-primary">add</a>
	</div>
</body>
</html>