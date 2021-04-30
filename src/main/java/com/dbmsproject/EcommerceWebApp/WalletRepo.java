package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WalletRepo {

	Connection con;
	
	public WalletRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public Wallet getMyWallet(int cID) {
		
		Wallet w = null;
		try{
			PreparedStatement ps = con.prepareStatement("select c.cID, c.cFirst_name, c.cLast_name, w.wpass, w.wamount, w.points\r\n"
														+ "from wallet w, customers c\r\n"
														+ "where w.cID = c.cID and c.cID = ?");
			ps.setInt(1, cID);
			System.out.println("cID: "+cID);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				w = new Wallet(rs.getInt(1), rs.getString(2)+" "+rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getInt(6));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return w;
	}
	
}
