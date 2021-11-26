<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="userModel" class="com.yash.modal.UserModel" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>User Details</h3>
	<p>Name : ${userModel.firstName } ${userModel.lastName}</p>
	<p>Gender : ${userModel.gender }</p>
	<p>Email : ${userModel.email }</p>
	<p>Contact : ${userModel.contact } </p>
	<p>Address : ${userModel.address } </p>
</body>
</html>