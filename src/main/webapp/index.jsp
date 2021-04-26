<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.ProductRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Product" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
   body {
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
   }
   .productCard {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      max-width: 300px;
      margin: 2px;
      text-align: center;
      font-family: arial;
      background-color: rgb(190, 224, 224);
   }
   .productDetails {
      color: rgb(26, 0, 51);
      font-weight: bold;
      font-size: 18px;
   }
   button {
      border: none;
      outline: 0;
      display: inline-block;
      padding: 8px;
      color: white;
      background-color: rgb(23, 31, 102);
      text-align: center;
      cursor: pointer;
      width: 100%;
      font-size: 18px;
   }
   button:hover, a:hover {
      opacity: 0.7;
   }
   div.gallery {
	  margin: 5px;
	  border: 1px solid #ccc;
	  float: left;
	  width: 180px;
	  hight: 300px;
	  padding: 20px;
	}
	
	div.gallery:hover {
	  border: 1px solid #777;
	}
	
	div.gallery img {
	  width: 200;
	  height: 300;
	}
	
	div.desc {
	  padding: 15px;
	  text-align: center;
	}
</style>
<title>Home</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css\nav.css"/>
</head>
<body>
    <script src="js\nav.js"></script>
<%
	if(session.getAttribute("email") == null){
%>
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
    </nav><br><br><br><br><br>
			welcome <%= (String)session.getAttribute("email") %> <br>
<%
	}

	ProductRepo pr = new ProductRepo();
	ArrayList<Product> list = pr.getAllProducts();
	

	for(Product p : list){
%>
		<div class="gallery">
			<div class="productCard">
				<img src= <%= p.getImage() %>
				style="width:100%"/>
				<strong><%= p.getPname() %></strong>
				<p class="productDetails"><%= p.getDescription() %></p>
				<p><%= p.getPrice() %></p>
			</div>
			<form action="ATC_BN_Processer" method="post">
			  <label for="quantity">Quantity: </label>
			  		<select name="quantity">
			  			<option value= 1 >1</option>
				        <option value= 2 >2</option>
				        <option value= 3 >3</option>
				        <option value= 4 >4</option>
			  		</select>
			  		
			  		<input type="hidden" id="pID" name="pID" value = <%= p.getpID() %>>
			  		<input type="hidden" id="sID" name="sID" value = <%= p.getsID() %>>
			  		<input type="hidden" id="price" name="price" value = <%= p.getPrice() %>>
			  		
			  		
			  <button type="submit" name="submit" value="product_details" >Product Details</button><br>		
			  <button type="submit" name="submit" value="add_to_cart" >Add to cart</button><br>
			  <button type="submit" name="submit" value="buy_now" >Buy Now</button><br>
			</form>
			
			<!-- 
				<p><button>Add to cart</button></p>
			    <p><button>Buy Now</button></p>
			 -->
			
			
		</div>
<%
	}
%>
</body>
</html>
