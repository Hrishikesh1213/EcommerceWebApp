package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewRepo {
	
	Connection con;
	
	public ReviewRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public int insertIntoReview(Review r) {
		int status = 0;
		
		try {
			int count = 0;
			PreparedStatement ps1 = con.prepareStatement("SELECT count(*) FROM review WHERE pID=? AND cID=? AND sID=?");
			ps1.setInt(1, r.getpID());
			ps1.setInt(2, r.getcID());
			ps1.setInt(3, r.getsID());
			
			ResultSet rs = ps1.executeQuery();
			rs.next();
			count = rs.getInt(1);
			System.out.println("count: "+count);
			
			PreparedStatement ps;
			
			if(count == 0) {
				
				ps = con.prepareStatement("INSERT INTO review VALUES (?,?,?,?,?)");
				ps.setInt(1, r.getpID());
				ps.setInt(2, r.getcID());
				ps.setInt(3, r.getsID());
				ps.setInt(4, r.getRating());
				ps.setString(5, r.getReview());
				
			}
			else {
				
				ps = con.prepareStatement("UPDATE review SET rating = ?, review = ? WHERE pID=? AND cID=? AND sID=?");
				ps.setInt(1, r.getRating());
				ps.setString(2, r.getReview());
				ps.setInt(3, r.getpID());
				ps.setInt(4, r.getcID());
				ps.setInt(5, r.getsID());

			}
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<Review> getProductReview(int pID){

		ArrayList<Review> list = new ArrayList<Review>();
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM review WHERE pID = ? ");
			ps.setInt(1, pID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public Review getMyProductReview(int pID, int cID){
		
		Review r = null;
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM review WHERE pID = ? and cID = ?");
			ps.setInt(1, pID);
			ps.setInt(2, cID);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				rs.next();
				r = new Review(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return r;
	}
	
}
