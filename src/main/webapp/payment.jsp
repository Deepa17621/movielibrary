<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
movie Price:<%= session.getAttribute("movieprice") %>
<form action="payment">

amount:<input name="amount" type="number" required>
<input type="submit">
</form>
</body>
</html>