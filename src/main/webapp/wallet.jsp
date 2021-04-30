<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.CartRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.OrderStatus" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.WalletRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Wallet" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wallet</title>
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
    </nav>
			welcome <%= (String)session.getAttribute("email") %> <br><br><br><br>
			
<%
	}
%>
<h2></h2><br>

<%
int cID = Integer.parseInt(session.getAttribute("cID").toString());
	WalletRepo wr = new WalletRepo();
	Wallet w  = wr.getMyWallet(cID);

%>

<h1>ID: <%= w.getcID() %></h1><br>
<h1>Name: <%= w.getName() %></h1><br>
<h2>Amount: <%= w.getAmount() %></h2><br>
<h2>Points: <%= w.getPoints() %></h2><br>

<h2>Previous Transactions</h2><br>

<%
	//CardRepo ar = new CardRepo();
	CartRepo cr = new CartRepo();
	ArrayList<OrderStatus> list = cr.getMyTransaction(cID);
%>
<form action = "DA_Processer" method = "post">
	
	<table id="address">
				<thead>
					<tr>
						<th>Date</th>
						<th>Transaction ID</th>
						<th>Amount</th>
					</tr>
				</thead>
<% 
	for(OrderStatus os : list){
%>
				<tr>
						<td><%= os.getOrderdate()   %></td>
						<td><%= os.gettID() 		%>	</td>
						<td><%= os.getCost()		%>	</td>
				</tr>
<%
	}
%>
	</table><br>

<h2>Add new Card</h2>


</body>
</html>