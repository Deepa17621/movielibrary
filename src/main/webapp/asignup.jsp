<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">

body {
            display: flex;
            justify-content: center;
            align-items: center;
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

<div class= "signup-page">
<form action="adminsignup" method="post">
Admin id:<input type="number" name="aid"><br>
Admin name: <input type="text" name="aname"><br>
Admin contact: <input type="tel" name="acontact"><br>
Admin mail:<input type="email" name="mail"><br>
Admin password: <input type="password" name="password"><br>

<br>
<input type="submit" style="background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 3px; cursor: pointer;">


</form>
</div>

</body>
</html>