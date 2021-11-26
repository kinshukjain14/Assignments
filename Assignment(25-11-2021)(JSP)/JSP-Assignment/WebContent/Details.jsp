<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="userModel" class="com.yash.modal.UserModel" scope="session"/>
	<jsp:setProperty property="*" name="userModel"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="success.jsp"></jsp:forward>
</body>
</html>