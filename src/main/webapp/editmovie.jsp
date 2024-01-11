<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.h1{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color: black;
    
}
</style>
</head>
<body>
<% Movie m=(Movie)request.getAttribute("movie"); %>
<form action="updatemovie" enctype="multipart/form-data" method="post">
<h1 class="h1">Edit Movie Details Here!!</h1>
Movie id:<input type="number" name="id" value="<%=m.getMovieid() %>" readonly><br>
<br>
Movie Name:<input type="text" name="name" value="<%=m.getMovivename() %>"><br>
<br>
Movie Price:<input type="number" name="price" value="<%=m.getMovieprice() %>"><br>
<br>
Movie Rating:<input type="text" name="rating" value="<%=m.getMovierating() %>"><br>
<br>
Movie genre:<input type="text" name="genre" value="<%=m.getMoviegenre() %>"><br>
<br>
Movie Lang:<input type="text" name="language" value="<%=m.getMovielang() %>"><br>
<br>
Movie image:<input type="file" name="image"><br>
<br>
<input type="submit">

</form>
<% String base64Image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<img src="data:image/jpeg;base64, <%=base64Image %>" height="100px" width="100px">
</body>
</html>