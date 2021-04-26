<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.AddressRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.Address" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delivary Address</title>
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

<h2>select delivary location</h2>

<%
	int cID = Integer.parseInt(session.getAttribute("cID").toString());
	AddressRepo ar = new AddressRepo();
	ArrayList<Address> list = ar.getMyAddress(cID);
	
	String err= "Hello";
%>
<form action = "DA_Processer" method = "post">
	
	<table id="address">
				<tr>
					<tr>
						<th>Select</th>
						<th>Address</th>
					</tr>
				</tr>
<% 
	for(Address a : list){
%>
				<tr>
						<td><input type="radio" name="address" value= "<%= a.getPrimaryKey() %>" required></td>
						<td>
							Mr/Ms <%= a.getName()%><br>
							<%=a.getColony() %>, <%= a.getHno()%>, <%= a.getLandmark()%>  <br>
							<%=a.getCity() %>, <%= a.getPin()%>  <br>
							<%=a.getState() %>, <%= a.getCountry()%>  <br>
						</td>
				</tr>
<%
	}
%>
	</table><br>
	<button type="submit" name="submit" value="select_address" >Proceed to payment</button><br>
</form>
<br><br><br><br>






<h2>Add new delivary location</h2>

<form action = "DA_Processer" method = "post">

	<label for="name"><b>Full name (First and Last name): </b></label><br>
    <input type="text" placeholder="Enter Name" name="name" required><br>
    
    <label for="phno"><b>Mobile number: </b></label><br>
    <input type="text" placeholder="10 -digit mobile or landline whithout prefixes" name="phno" required><span><%=err %></span><br>
    
    <label for="pin"><b>PIN code: </b></label><br>
    <input type="text" placeholder="6 digits [0-9] PIN code" name="pin" required><br>
    
    <label for="hno"><b>Flat, House no., Building, Company, Apartment: </b></label><br>
    <input type="text" placeholder="" name="hno" required><br>
    
    <label for="colony"><b>Area, Colony, Street, Sector, Village: </b></label><br>
    <input type="text" placeholder="" name="colony" required><br>
    
    <label for="landmark"><b>Landmark: </b></label><br>
    <input type="text" placeholder="E.g. Near AIIMS Flyover, Behind Regal Cinema, etc." name="landmark" ><br>
    
    <label for="city"><b>Town/City: </b></label><br>
    <input type="text" placeholder="" name="city" required><br>
    
    <label for="name"><b>State / Province / Region: </b></label><br>
    <input type="text" placeholder="Enter Name" name="state" required><br>
    
    <label for="state"><b>Country/Region: </b></label><br>
    <input type="text" placeholder="" name="country" required><br>
    
    <label for="addr_type">Address Type: </label>
			  		<select name="addr_type">
			  			<option value= "Home" >Home (7 AM - 9 PM delivery)</option>
				        <option value= "Office/Commercial" >Office/Commercial (10 AM - 6 PM delivery)</option>
			  		</select>
    
    <button type="submit" name="submit" value="add_address" >Add Address</button><br>
	
</form>

</body>
</html>