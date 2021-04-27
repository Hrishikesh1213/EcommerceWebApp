<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
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

    <label for="email"><b>Email: </b></label>
    <input type="email" placeholder="Enter Email" name="email" required><br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br>
        
    <button type="submit" name="submit" value="login" >Login</button><br>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>


    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
</form>
<br>	<br>
<a href="sellerlogin.jsp">Seller login</a>

</body>
</html>