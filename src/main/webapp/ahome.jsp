<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css"> 
th, td{
	padding:25px;
	
}
th, td, table{
	border-collapse: collapse;
	
}
</style>
</head>
<body style="background-color:powderblue;">
<h3>Welcome</h3>

<% List<Movie> movie=(List<Movie>)request.getAttribute("movies"); %>
<table border="2px">
<tr>
<th>id</th>
<th>name</th>
<th>price</th>
<th>rating</th>
<th>genre</th>
<th>language</th>
<th>image</th>
<th>delete</th>
<th>Edit</th>
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

<td><a href="deletemovie?id=<%=m.getMovieid() %>">Delete</td>
<td><a href="editemovie?id=<%=m.getMovieid() %>">Edit</td>
</tr>
<% } %>

</table>
<a href="addmovie.jsp">Click here to Add Movie</a>
</body>
</html>