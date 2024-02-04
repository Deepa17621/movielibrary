<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
h1{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color:white;
    
}
body 
{
            
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            /* Set background image for the entire site */
            background-image: url('https://img.freepik.com/free-photo/movie-background-collage_23-2149876028.jpg');
            background-size: cover; /* Adjust as needed */
            background-repeat: no-repeat;
            background-position: center;
            }

form {
            width: 400px; /* You can adjust the width as needed */
            margin: 20px; /* Adjust the margin as needed */
            padding: 25px;
            border: 2px solid #ccc;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            max-width: 100%;
         
        }
        
.signup-page {
            background-image: none; /* Or set a different background for the login page */
            padding: 150px;
            padding-left:500px;
           
        }
        
       /* .h4{

    font-size: 50px;
    line-height: 20px;
    text-align: center;
    color: white;
    margin: 0; /* Remove default margin for h1 */
           
    
}*/

        
</style>
</head>
<body>
<h1>Sign-Up Page For User</h1>
<div class= "signup-page">
<form action="usersignup" method="post">
user id:<input type="number" name="id"><br>
user name: <input type="text" name="name"><br>
user contact: <input type="tel" name="contact"><br>
user mail:<input type="email" name="mail"><br>
user password: <input type="password" name="password"><br>

<br>
<input type="submit">


</form>
</div>
</body>
</html>