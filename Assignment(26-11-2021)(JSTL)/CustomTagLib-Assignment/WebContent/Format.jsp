<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib uri="http://www.yash.com/tags/format" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Before Formatting</p>
	<p>normal content</p>
	<p>After Formatting</p>
	<custom:format toCase="upper">
		<p>normal content</p>	
	</custom:format>
</body>
</html>