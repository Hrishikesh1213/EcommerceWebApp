<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.ProductRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Product" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.ReviewRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Review" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product.jsp</title>
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
            <li><a href="#">Previous Orders</a></li>
            <li><a href="mycart.jsp">My Cart</a></li>
            <li><a href="#">Contact Us</a></li>
            <li>
            	<form action = "SessionDataClear" method = "post">
            		<button type="submit" class="login-button">Logout</button>
            	</form>
            
            </li>

        </ul>
    </nav>
<%
	}
%><br><br><br><br>
<h1>This is product.jsp</h1>

<%
	int pID = Integer.parseInt(request.getParameter("pID").toString());
	ProductRepo pr = new ProductRepo();
	ArrayList<Product> list = pr.getProductInfo(pID);
%>
<img src= <%= list.get(0).getImage() %> style="width:500px"/><br>
<%= list.get(0).getpID() %><br>
<%= list.get(0).getCategory() %><br>
<%= list.get(0).getPname() %><br>
<%= list.get(0).getDescription() %><br>


<form action="ATC_BN_Processer" method="post">
			  <label for="quantity">Quantity: </label>
			  		<select name="quantity">
			  			<option value= 1 >1</option>
				        <option value= 2 >2</option>
				        <option value= 3 >3</option>
				        <option value= 4 >4</option>
			  		</select>
			  		
			  		<input type="hidden" id="pID" name="pID" value = <%= list.get(0).getpID() %>>
			  		<table>
					  <tr>
					    <th>Select</th>
					    <th>Seller Name</th>
					    <th>Price of 1 Unit</th>
					  </tr>
<% 
	for(Product p : list){
%>
				<tr>
						<td><input type="radio" name="sID" value= "<%= p.getsID() %>" required></td>
						<td><%= p.getSname() 		%>	</td>
						<td><%= p.getPrice() 		%>	</td>
				</tr>
<%
	}
%>
					</table>		  		
			  		
	<button type="submit" name="submit" value="add_to_cart" >Add to cart</button><br>
	<button type="submit" name="submit" value="buy_now" >Buy Now</button><br>
</form>
<br><br><br><br>
<h2>Write or Upadate review</h2>

<form action="ATC_BN_Processer" method="post">
			  <label for="rating">Rating: </label>
			  		<select name="rating" required>
			  			<option value= 1 >1</option>
				        <option value= 2 >2</option>
				        <option value= 3 >3</option>
				        <option value= 4 >4</option>
				        <option value= 5 >5</option>
			  		</select>
			  		
			  			<label for="review"><b>Review</b></label>
    					<input type="text" placeholder="Enter review/comments " name="review"><br>
			  		
			  		<input type="hidden" id="pID" name="pID" value = <%= list.get(0).getpID() %>>
			  		<table>
					  <tr>
					    <th>Select</th>
					    <th>Seller Name</th>
					  </tr>
<% 
	for(Product p : list){
%>
				<tr>
						<td><input type="radio" name="sID" value= "<%= p.getsID() %>" required></td>
						<td><%= p.getSname() 		%>	</td>
				</tr>
<%
	}
%>
					</table>		  		
			  		
	<button type="submit" name="submit" value="post_the_review" >Post the review</button><br>
</form>
<br><br>
<h2>review dashboard</h2>

<%
	ReviewRepo rr = new ReviewRepo();
	ArrayList<Review> rl = rr.getProductReview(pID); 
	
	for(Review r : rl){
%>
		<h5><%= r.toString() %></h5>
<%
	}
%>
</body>
</html>