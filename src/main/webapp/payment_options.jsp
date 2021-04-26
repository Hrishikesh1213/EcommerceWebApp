<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.CardRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Cards" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.PaymentsType" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.PaymentsTypeRepo" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Options</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css\nav.css"/>
<style>
	#address {
	  font-family: Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	#address td, #customers th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}
	
	#address tr:nth-child(even){background-color: #f2f2f2;}
	
	#address tr:hover {background-color: #ddd;}
	
	#address th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: #4CAF50;
	  color: white;
	}

</style>
</head>
<body>
<%
	if(session.getAttribute("email") == null){
%>
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
            <li><a href="#">Solutions</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="register.jsp">Register</a></li>

        </ul>
    </nav>
    <br><br><br><br>
<%
	}
	else{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
%>
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
            <li><a href="#">Solutions</a></li>
            <li><a href="prev_orders.jsp">Previous Orders</a></li>
            <li><a href="mycart.jsp">My Cart</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
            <li>
            	<form action = "SessionDataClear" method = "post">
            		<button type="submit" class="login-button">Logout</button>
            	</form>
            
            </li>

        </ul>
    </nav>
			welcome <%= (String)session.getAttribute("email") %> <br><br><br><br>
			
<%
	}
%>

<h2>select card</h2>

<%
	int cID = Integer.parseInt(session.getAttribute("cID").toString());
	//CardRepo ar = new CardRepo();
	PaymentsTypeRepo ptr = new PaymentsTypeRepo();
	ArrayList<PaymentsType> list = ptr.getMyPaymentsType(cID);
%>
<form action = "DA_Processer" method = "post">
	
	<table id="address">
				<thead>
					<tr>
						<th>Select</th>
						<th>Transaction Type</th>
					</tr>
				</thead>
<% 
	for(PaymentsType pt : list){
%>
				<tr>
						<td><input type="radio" name="paymenttype" value= "<%= pt.getTranstype() %>" required></td>
						<td><%= pt.getTranstype() 		%>	</td>
				</tr>
<%
	}
%>
	</table><br>
	<button type="submit" name="submit" value="select_payment_type" >Proceed to payment</button><br>
</form><br><br><br>

<h2>-------------------------------------------------------------------------</h2>





<h2>Add new Card</h2>

<form action = "DA_Processer" method = "post">
    
    <label for="cardNo"><b>Enter new Payment Type: </b></label><br>
    <input type="text" placeholder="Enter either of below" name="paymenttype" required><br>
    
    <button type="submit" name="submit" value="add_new_payment_type" >Add new type</button><br>
	
</form>

</body>
</html>