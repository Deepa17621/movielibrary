<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Add Movie</h2>

<form action="addmovie" enctype="multipart/form-data" method="post">
Movie id:<input type="number" name="id"><br>
<br>
Movie Name:<input type="text" name="name"><br>
<br>
Movie Price:<input type="number" name="price"><br>
<br>
Movie Rating:<input type="text" name="rating"><br>
<br>
Movie genre:<input type="text" name="genre"><br>
<br>
Movie Lang:<input type="text" name="language"><br>
<br>
Movie image:<input type="file" name="image"><br>
<br>
<input type="submit">

</form>
</body>
</html>