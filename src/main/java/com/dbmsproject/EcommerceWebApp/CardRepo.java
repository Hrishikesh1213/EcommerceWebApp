package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardRepo {
	Connection con;

	public CardRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
	public int insertIntoCard(Cards c) {
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO card(cID, cardNo, pin ) VALUES (?,?,?)");
			ps.setInt(1, c.getcID());
			ps.setString(2, c.getCardNo());
			ps.setString(3, c.getPin());
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<Cards> getMyCard(int cID){

		ArrayList<Cards> list = new ArrayList<Cards>();
		
		try{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM card where cID = ? ");
			ps.setInt(1, cID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Cards(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;
	}

}
