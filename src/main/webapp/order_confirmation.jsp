<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.CartRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.MyCart" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>
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


<%
	String buy_now = session.getAttribute("buy_from").toString();
	if(buy_now.equals("BUY_NOW")){
	
		int cID = Integer.parseInt(session.getAttribute("cID").toString());
	
		int pID = Integer.parseInt(session.getAttribute("pID").toString());
		int sID = Integer.parseInt(session.getAttribute("sID").toString());
		int price = Integer.parseInt(session.getAttribute("price").toString());
		int quantity = Integer.parseInt(session.getAttribute("quantity").toString());
		
		int tot_amount = price*quantity;
		
		CartRepo cr = new CartRepo();
		MyCart mc =  cr.getProductDetails(pID, sID);
%>
	Product: <%=mc.getPname() %><br>
	Seller: <%=mc.getSname() %><br>
	Price: <%=mc.getPrice() %><br>
	Quantity: <%=quantity %><br>
	Total: <%=tot_amount %><br>
<%
	}
	else if(buy_now.equals("BUY_FROM_CART")){
		CartRepo cr = new CartRepo();

%>
		get data from cart
		<table id="address">
		<th>
			<td>Image</td>
			<td>Name</td>
			<td>seller</td>
			<td>MRP</td>
			<td>Quantity</td>
			<td>Cost</td>
		</th>
<%
		int cID = Integer.parseInt(session.getAttribute("cID").toString());

		ArrayList<MyCart> list = cr.getMyCart(cID);
		int total = 0;
		
		for(MyCart mc : list){
			total = total + mc.getCost();

%>
			<tr>
				<td>HRisih</td>
				<td><img src="data:image/jpg;base64,<%= mc.getImage() %>" width="100" height="150"></td>
				<td><%= mc.getPname() %></td>
			    <td><%= mc.getSname() %></td>
			    <td><%= mc.getPrice() %></td>
			    <td><%= mc.getQuantity() %></td>
			    <td><%= mc.getCost() %></td>
			</tr>
<%
		}
%>
		</table>
		<h2>Total cost = <%= total %></h2>
<%
	}
%>
<form action = "OrderProcessor" method = "post">
	
	<button type="submit" name="submit" value="order_confirmed" >confirm</button><br>
</form>

</body>
</html>