<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <link rel="stylesheet" href="css\nav.css"/>
    
</head>
<body>

<script src="js\nav.js"></script>
	<nav>
        <div class="logo">
            <img src="images\logo.jpg" alt="Logo Image" >
        </div>
        <div class="hamburger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>
        <ul class="nav-links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">Solutions</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="register.jsp">Register</a></li>

        </ul>
    </nav>
    <br><br><br><br>

<h4 style="color: red;">${Message}</h4><br>
<h4 style="color: green;">${successMessage}</h4>
<form action = "LoginRegister" method = "post">

	<label for="fname"><b>Firat Name</b></label>
    <input type="text" placeholder="Enter name" name="fname" required><br>
    
    <label for="lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter name" name="lname" required><br>

    <label for="email"><b>Email: </b></label>
    <input type="email" placeholder="Enter Email" name="email" required><br>
    

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    
    <label for="password1"><b>Confirm Password</b></label>
    <input type="password" placeholder="Re-enter Password" name="password1" required><br>
        
    <button type="submit" name="submit" value="register" >Register</button><br>

</form>
</body>
</html>