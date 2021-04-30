<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank you for shopping</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css\nav.css"/>
</head>
<body>
<script src="js\nav.js"></script>

	<nav>
        <div class="logo">
            <img src="images\logo.jpg" alt="Logo Image">
        </div>
        <div class="hamburger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>
        <ul class="nav-links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="wallet.jsp">wallet</a></li>
            <li><a href="prev_orders.jsp">Previous Orders</a></li>
            <li><a href="mycart.jsp">My Cart</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
            <li>
            	<form action = "SessionDataClear" method = "post">
            		<button type="submit" class="login-button">Logout</button>
            	</form>
            
            </li>

        </ul>
    </nav><br><br><br><br><br>

<%
	String trans_code = session.getAttribute("status_of_buynow_checkout").toString();
	if(trans_code.equals("I00001")){
%>
		<h1>Thank you for shopping with us</h1><br>
		<h2>Your order has been placed successfully</h2><br>
		<h2>please return to home page</h2><br>
<%
	}
	else if(trans_code.equals("E00027")){
%>
		<h1>Sorry for the Inconvenience</h1><br>
		<h2>The transaction is failed due to </h2><br>
		<h2><%= session.getAttribute("error_message").toString() %></h2><br>
		<h2>please return to home page and try again</h2><br>
<%	
	}
%>


</body>
</html>