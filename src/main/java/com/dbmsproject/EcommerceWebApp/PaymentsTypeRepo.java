package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsTypeRepo {

	Connection con;
	
	public PaymentsTypeRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public ArrayList<PaymentsType> getMyPaymentsType(int cID){
		ArrayList<PaymentsType> list = new ArrayList<PaymentsType>();
		
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM payment_options WHERE cID = ?");
			ps.setInt(1, cID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new PaymentsType(rs.getInt(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PaymentsType pt : list) {
			System.out.println(pt.toString()+"qwertyuiop");
		}
		System.out.println("return ing successfully");

		return list;
	}

	public int insertNewPaymentType(PaymentsType paymentsType) {
			
		int status = 0;
		
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO payment_options VALUES (?,?)");
			ps.setInt(1, paymentsType.getcID());
			ps.setString(2, paymentsType.getTranstype());
			
			status = ps.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

}
