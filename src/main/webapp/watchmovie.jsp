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
table{
margin-left: auto;
margin-right: auto;
}

th, td{
	padding:20px;
	
}
th, td, table{
	border-collapse: collapse;
	
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

<% List<Movie> movie=(List<Movie>)request.getAttribute("movie"); %>
<h4 class="h1">Movies List You Have Bought</h4>
<table border="2px">
<tr>
<th>id</th>
<th>name</th>

<th>image</th>
<th>Delete Movie</th>
</tr>
<% for(Movie m : movie) { %>
<tr>
<td><%=m.getMovieid() %></td>
<td><%=m.getMovivename() %></td>


<% String base64Image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<td><img src="data:image/jpeg;base64, <%=base64Image %>" height="100px" width="100px"></td>
<td><a href="deletemoviemovie?id=<%=m.getMovieid() %> "> Delete Movie</a></td>
</tr>
<% } %>
</body>
</html>