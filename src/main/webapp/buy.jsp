<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Portal</title>
</head>
<body>
<h1>Welcome to Payment Portal</h1><br>

<%
	String buy_now = session.getAttribute("buy_from").toString();
	if(buy_now.equals("BUY_NOW")){
%>
		get data from session
<%
		
	}
	else if(buy_now.equals("BUY_FROM_CART")){
%>
		get data from cart
<%
	}
%>


</body>
</html>