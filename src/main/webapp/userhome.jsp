<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css"> 
th, td{
	padding:20px;
	
}
th, td, table{
	border-collapse: collapse;
	
}
table{
margin-left: auto;
margin-right: auto;
}

.h1{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color: black;
    
    
}

</style>
</head>
<body>

<h1 class="h1">Hello,Welcome to Home Page!!</h1>
<% List<Movie> movie=(List<Movie>)request.getAttribute("movies"); %>

<table border="2px" >
<tr>
<th>id</th>
<th>name</th>
<th>price</th>
<th>rating</th>
<th>genre</th>
<th>language</th>
<th>image</th>
<th>Buy</th>
</tr>
<% for(Movie m : movie) { %>
<tr>
<td><%=m.getMovieid() %></td>
<td><%=m.getMovivename() %></td>
<td><%=m.getMovieprice() %></td>
<td><%=m.getMovierating() %></td>
<td><%=m.getMoviegenre() %></td>
<td><%=m.getMovielang() %></td>

<% String base64Image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<td><img src="data:image/jpeg;base64, <%=base64Image %>" height="100px" width="100px"></td>
<td><a href="saveusermovie?id=<%=m.getMovieid() %> "> Buy</a></td>
</tr>
<% } %>
</table>
<div>
<a href="watchmovie">Watch movie</a>
<br>
<a href="userlogout">LogOut</a>
</div>

<br>
</body>
</html>