package com.dbmsproject.EcommerceWebApp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConfirmRepo {

	Connection con;
	
	public ConfirmRepo() {
		try{
			con=MyConnectionProvider.getCon();
			//con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public String callCheckout(int cID, String phno, String addr, String payment_methode) {
		
		String runSP = "{ call checkout(?,?,?,?) }";
        String ret = null;

        CallableStatement cs;
		try {
			cs = con.prepareCall(runSP);
			cs.setInt(1, cID);
	        cs.setString(2,phno);
	        cs.setString(3,addr);
	        cs.setString(4,payment_methode);
	                     
	        cs.execute();
	        
	        cs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			String err_msg = e.getMessage().split("~")[1];
			
			System.out.println("->>>>>>>>>>>>>>>>>"+err_msg);
			ret = err_msg;


		}
		return ret;
	}
	
	public String callBuyThis(int cID, int pID, int sID, int quantity, String phno, String addr, String payment_methode) {
		
        String runSP = "{ call buy_this(?,?,?,?,?,?,?) }";        
        String ret = null;

        CallableStatement cs;
		try {
			cs = con.prepareCall(runSP);
            cs.setInt(1, cID);
            cs.setInt(2, pID);
            cs.setInt(3, sID);
            cs.setInt(4, quantity);
            cs.setString(5,payment_methode);
            cs.setString(6,phno);
            cs.setString(7,addr);
            
            cs.execute(); 
	        
	        cs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();

			String err_msg = e.getMessage().split("~")[1];
			
			System.out.println("->>>>>>>>>>>>>>>>>"+err_msg);
			ret = err_msg;
		}
		return ret;
	}

}
