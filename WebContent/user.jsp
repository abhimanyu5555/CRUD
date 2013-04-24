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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<script type="text/javascript">
		$(function(){
			$('input[name=dob]').datepicker();
		});
	</script>
</head>
<body>
	<form action="servlet" method="POST" class="form-actions">
	<!-- <form action="Edit_Servlet" method="POST" class="form-actions"> -->
		<table>
			<tr>
				<td>userid:</td><td>
									<input type="text" readonly="readonly" name="userId" value="<c:out value="${user.userid}"/>">
								</td>
			</tr>
			<tr>
				<td>firstname:</td><td>
										<input type="text" name="firstname" value="<c:out value="${user.firstName}"/>">
									</td>
			</tr>
			<tr>
				<td>lastname:</td> <td>
										<input type="text" name="lastname" value="<c:out value="${user.lastName}"/>">
									</td>
			</tr>
			<tr>
				<td>dob:</td> <td>
								<input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}"/>">
							</td>  
			</tr>
			<tr>
				<td>email</td> <td>
									<input type="text" name="email" value="<c:out value="${user.email}"/>">
								</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-primary">
	</form>
	
	fuck
	
</body>
</html>