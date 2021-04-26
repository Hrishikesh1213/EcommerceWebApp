package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
				list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),rs.getInt(9)));
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
				list.add(new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8),rs.getInt(9)));
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
