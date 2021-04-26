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
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

</style>
<title>My Cart</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css\nav.css"/>
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

<table>
  <tr>
    <th>Image</th>
    <th>Product Name</th>
    <th>Seller Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Cost</th>
  </tr>
<% 
		CartRepo cr = new CartRepo();
		
		int cID = Integer.parseInt(session.getAttribute("cID").toString());

		ArrayList<MyCart> list = cr.getMyCart(cID);
		
		if(list.size() == 0){
%>
			<h1>Cart is Empty</h1><br>
			<h2>Proceed to shopping area</h2>
<%
		}
		else{
		
		for(MyCart mc : list){

%>
		<tr>
		    <td><img src= <%= mc.getImage() %> width="100" height="150"></td>
		    <td><%= mc.getPname() %></td>
		    <td><%= mc.getSname() %></td>
		    <td><%= mc.getPrice() %></td>
		    <td><%= mc.getQuantity() %></td>
		    <td><%= mc.getCost() %></td>
		    <td>
		    	<form action="ATC_BN_Processer" method="post">
			    	<input type="hidden" id="cID" name="cID" value = <%= cID %>>
			    	<input type="hidden" id="pID" name="pID" value = <%= mc.getpID() %>>
			    	<input type="hidden" id="sID" name="sID" value = <%= mc.getsID() %>>
			    	
				  	<button type="submit" name="submit" value="delete_from_cart" >Delete</button><br>
			  	</form>
		    </td>
		</tr>
<%
		}
%>
</table>


<form action="ATC_BN_Processer" method="post">
			  <button type="submit" name="submit" value="buy_now_from_cart" >Buy Now</button><br>
</form>
<%
		}
%>
</body>
</html>