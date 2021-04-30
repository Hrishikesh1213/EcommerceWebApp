package com.dbmsproject.EcommerceWebApp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

public class ProductRepo {
	
	Connection con;
	PreparedStatement ps;
	
	public ProductRepo() {
		
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public ArrayList<Product> getAllProducts(){
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try{
			
			String sql = "select p.pID, ap.sID, s.name as sname, p.name as pname , p.description, ap.price,p.image, p.category,ap.quantity\r\n"
						+ "from product p, available_products ap, seller s, pID_minprice_view v\r\n"
						+ "where p.pID = ap.pID and ap.sID = s.sID and ap.price = v.min_price and p.pID = v.pID\r\n"
						+ "order by p.pID ";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Blob blob = rs.getBlob(7);
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
				list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), base64Image, rs.getString(8),rs.getInt(9)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
		
	}
	
	public ArrayList<Product> getProductInfo(int pID) {
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try{
			
			String sql = "select p.pID, ap.sID, s.name as sname, p.name as pname , p.description, ap.price,p.image, p.category,ap.quantity\r\n"
					+ "from product p, available_products ap, seller s\r\n"
					+ "where p.pID = ap.pID and ap.sID = s.sID AND p.pID = ? \r\n"
					+ "order by p.pID";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blob blob = rs.getBlob(7);
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
				list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), base64Image, rs.getString(8),rs.getInt(9)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public int getProductPricing(int pID, int sID) {
			
			int price = 0;
			
			try{
				
				String sql = "SELECT price FROM available_products WHERE pID =? AND sID = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, pID);
				ps.setInt(2, sID);
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				price = rs.getInt(1);
			}
			catch(Exception e){
				System.out.println(e);
			}
			return price;
		}
	
	
	
	

}
