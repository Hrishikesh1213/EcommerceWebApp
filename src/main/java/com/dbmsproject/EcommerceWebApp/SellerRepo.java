package com.dbmsproject.EcommerceWebApp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SellerRepo {

	Connection con;
	PreparedStatement ps;
	
	public SellerRepo() {
		
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public Seller getSeller(String sname, String password) {
		
		Seller s = null;
		
		try{
			
			String sql = "SELECT * FROM seller WHERE name =? AND password = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			s = new Seller(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return s;
		
	}
	
	public int insertIntoProduct (String category, String name, String description, InputStream Image, int sID, int price, int quantity) {
		
		int status =0;
		try{
			
			String sql = "insert into exist_products values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setBlob(4, Image);
			ps.setInt(5, sID);
			ps.setInt(6, price);
			ps.setInt(7, quantity);
			
			status = ps.executeUpdate();

		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return status;
	}
	
	public ArrayList<SellerReport> getSellerReport (int sID) {
		
		ArrayList<SellerReport> list = new ArrayList<SellerReport>();
		try{
			
			String sql = "SELECT TRUNC(sold_date) AS adate, SUM(amount) AS day_amount, COUNT(*) AS day_count\r\n"
						+ "FROM sold_products\r\n"
						+ "WHERE sID = ? \r\n"
						+ "GROUP BY TRUNC(sold_date)\r\n"
						+ "ORDER BY TRUNC(sold_date) DESC";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new SellerReport(sID, rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}

		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return list;
	}
}
