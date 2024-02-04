<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
.button {
  background-color: red;
  border: none;
  color: white;
  padding: 10px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

}
.h1{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color: black;
    
}


</style>
</head>
<body class="body" style="background-color:white">
<h1 class="h1">Enter Valid Credentials to Login</h1>
<div style="text-align: center; display: block;">
<form action="userlogin" method="post">
user email:<input style="color: black;" class="input" type="email" name="email"><br>
<br>
user password: <input style="color: black;" class="input" type="password" name="password"><br>
<br>
<input class="button" type="submit">
 
</form>

<% String message=(String) request.getAttribute("message"); %>

<%if(message!=null) {%>
<%=message %>
<%} %>>
</div >
</body>
</html>