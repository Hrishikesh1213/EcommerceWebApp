package com.dbmsproject.EcommerceWebApp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class CartRepo {
	
	Connection con;
	
	public CartRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	/*
	public String getTimeStamp() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String str = dtf.format(now);
		return str;
	}
	*/
	public int insertIntoCart(Cart c) {
		int status = 0;
		
		try {
			int count = 0;
			PreparedStatement ps1 = con.prepareStatement("SELECT count(*) FROM cart WHERE pID=? AND cID=? AND sID=?");
			ps1.setInt(1, c.getpID());
			ps1.setInt(2, c.getcID());
			ps1.setInt(3, c.getsID());
			
			ResultSet rs = ps1.executeQuery();
			rs.next();
			count = rs.getInt(1);
			System.out.println("count: "+count);
			
			PreparedStatement ps;
			
			if(count == 0) {
				
				ps = con.prepareStatement("INSERT INTO cart VALUES (?,?,?,?,?)");
				ps.setInt(1, c.getpID());
				ps.setInt(2, c.getcID());
				ps.setInt(3, c.getsID());
				ps.setInt(4, c.getPrice());
				ps.setInt(5, c.getQuantity());				
			}
			else {
				
				ps = con.prepareStatement("UPDATE cart SET quantity = (quantity + ?) WHERE pID=? AND cID=? AND sID=?");
				ps.setInt(1, c.getQuantity());
				ps.setInt(2, c.getpID());
				ps.setInt(3, c.getcID());
				ps.setInt(4, c.getsID());

			}
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = -1;
		}
		
		return status;
	}
	
	public int deleteFromCart(int cID, int pID, int sID) {
		int status = 0;
		System.out.println("cID: "+cID+" pID: "+pID+" sID: "+sID);
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM cart WHERE cID = ? AND pID = ? AND sID = ?");
			ps.setInt(1, cID);
			ps.setInt(2, pID);
			ps.setInt(3, sID);
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<MyCart> getMyCart(int cID){

		ArrayList<MyCart> list = new ArrayList<MyCart>();
		
		try{
			PreparedStatement ps = con.prepareStatement //getTimestamp
								("SELECT c.pID,c.sID, p.image, p.name as pname, s.name as sname, ap.price, c.quantity, (ap.price * c.quantity) as cost\r\n"
								+ "FROM cart c, seller s, product p, available_products ap\r\n"
								+ "WHERE c.pID = p.pID AND p.pID = ap.pID AND c.sID = ap.sID AND c.sID = s.sID AND cID=?");
			ps.setInt(1, cID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob blob = rs.getBlob(3);
	            InputStream inputStream = blob.getBinaryStream();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	             
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);                  
	            }
	             
	            byte[] imageBytes = outputStream.toByteArray();
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	             
	             
	            inputStream.close();
	            outputStream.close();
				list.add(new MyCart(rs.getInt(1), rs.getInt(2), base64Image, rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public MyCart getProductDetails(int pID, int sID){

		MyCart mc = null;
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT ap.pID,ap.sID, p.image, p.name as pname, s.name as sname, ap.price\r\n"
														+ "FROM seller s, product p, available_products ap\r\n"
														+ "WHERE  p.pID = ap.pID AND s.sID = ap.sID AND ap.pID = ? AND ap.sID = ?");
			ps.setInt(1, pID);
			ps.setInt(2, sID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob blob = rs.getBlob(3);
	            InputStream inputStream = blob.getBinaryStream();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	             
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);                  
	            }
	             
	            byte[] imageBytes = outputStream.toByteArray();
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	             
	             
	            inputStream.close();
	            outputStream.close();
				mc = new MyCart(rs.getInt(1), rs.getInt(2), base64Image, rs.getString(4), rs.getString(5), rs.getInt(6), 0, 0);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return mc;
	}
	
	public ArrayList<OrderStatus> getMyPrevOrders(int cID){

		ArrayList<OrderStatus> list = new ArrayList<OrderStatus>();
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT \r\n"
					+ "p.name as pname, p.description as pdesc, s.name as sname, os.orderdate, t.tID, \r\n"
					+ "os.phno, os.address, os.transtype, os.deliverystatus, os.cost,os.quantity\r\n"
					+ "FROM order_status os, product p, seller s, transactions t\r\n"
					+ "WHERE os.pID = p.pID AND os.sID = s.sID AND os.orderdate = t.transdate AND os.cid = t.cid AND os.cID = ? ");
			ps.setInt(1, cID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(
						new OrderStatus(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),
										rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),0)
						);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public ArrayList<OrderStatus> getMyTransaction(int cID){

		ArrayList<OrderStatus> list = new ArrayList<OrderStatus>();
		
		try{
			PreparedStatement ps = con.prepareStatement("Select tID, transdate, amount from transactions where cID = ? and transtype = 'Wallet'");
			ps.setInt(1, cID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new OrderStatus( "", "", "", rs.getString(2), rs.getInt(1), "", "", "", "", rs.getInt(3), 0, 0)	);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	

}
