package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressRepo {
	
	Connection con;

	public AddressRepo() {
		
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public int insertIntoAddress(Address a) {
		int status = 0;
		String ret = "OK";
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO address VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, a.getcID());
			ps.setString(2, a.getName());
			ps.setString(3, a.getPhno());
			ps.setString(4, a.getPin());
			ps.setString(5, a.getHno());
			ps.setString(6, a.getColony());
			ps.setString(7, a.getLandmark());
			ps.setString(8, a.getCity());
			ps.setString(9, a.getState());
			ps.setString(10, a.getCountry());
			ps.setString(11, a.getAddr_type());
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("->>>>>>>>>>>>>>>>>>"+e.getMessage()+" "+e.getErrorCode());
			ret = "NO";
		}
		
		return status;
	}
	
	public ArrayList<Address> getMyAddress(int cID){

		ArrayList<Address> list = new ArrayList<Address>();
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM address where cID = ? ");
			ps.setInt(1, cID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
							rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public Address getMySpecficAddress(int cID, String name, String phno, String addr_type){

		Address a = null;
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM address where cID = ? AND name = ? AND phno = ? AND addr_type = ? ");
			ps.setInt(1, cID);
			ps.setString(2, name);
			ps.setString(3, phno);
			ps.setString(4, addr_type);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
							rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return a;
	}

}
