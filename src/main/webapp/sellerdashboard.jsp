<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.dbmsproject.EcommerceWebApp.SellerRepo" %>
<%@ page import="com.dbmsproject.EcommerceWebApp.SellerReport" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Dashboard</title>
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
	int sID = Integer.parseInt(session.getAttribute("sID").toString());
%>

----->>>>>>>>>>>>>><%= sID %><br>

<h2>Daily Transactions</h2>

<%
	SellerRepo sr = new SellerRepo();
	ArrayList<SellerReport> list = sr.getSellerReport(sID);
	
%>

	<table id="address">
				<tr>
					<tr>
						<th>Date</th>
						<th>Amount</th>
						<th>Count</th>
					</tr>
				</tr>
<% 
	for(SellerReport s : list){
%>
				<tr>
						<td><%= s.getDate() %></td>
						<td><%= s.getAmount() %></td>
						<td><%= s.getCount() %></td>
				</tr>
<%
	}
%>
	</table>

<br><br><br><br>


<h2>----------------------------------------------------------------------------------</h2><br>

<h2>Add the product</h2>

<br><br>



<form action = "SellerProcesser" method = "post" enctype="multipart/form-data">

	<label for="name"><b>Product Name: </b></label><br>
    <input type="text" placeholder="Enter Name" name="name" required><br>
    
    <label for="description"><b>description: </b></label><br>
    <input type="text" placeholder="description" name="description" required><br>
    
    <label for="category"><b>category: </b></label><br>
    <input type="text" placeholder="category" name="category" required><br>
    
    <label for="image"><b>image: </b></label><br>
    <input type="file" placeholder="image" name="image" required><br>
    
    <label for="price"><b>price: </b></label><br>
    <input type="number" placeholder="price" name="price" required><br>
    
    <label for="quantity"><b>Quantity: </b></label><br>
    <input type="number" placeholder="quantity" name="quantity" ><br>
    
    <button type="submit" name="submit" value="add_product" >Add Product</button><br>
	
</form>

</body>
</html>