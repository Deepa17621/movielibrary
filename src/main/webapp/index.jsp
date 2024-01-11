<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.button {
  background-color: white;
  border: none;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;

}
.h1{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color: white;
    
}
body {
  background-image: url('https://img.freepik.com/free-photo/movie-background-collage_23-2149876005.jpg?size=626&ext=jpg&ga=GA1.1.1412446893.1704585600&semt=aiss');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}

</style>
</head>
<h1 class="h1">Welcome to Movie Library Application</h1>
<body >
<div style="text-align: center; display: block;">
<a class="button" href="user.jsp">User</a><br>
<br>
<a class="button" href="admin.jsp">Admin</a>
</div>
</body>
</html>