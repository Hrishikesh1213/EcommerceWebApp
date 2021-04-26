package com.dbmsproject.EcommerceWebApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAOImpl implements ClientDAO {
	
	static Connection con;
	static PreparedStatement ps;

	@Override
	public int insertClient(Client c) {
		
		int status=0;
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("INSERT INTO customers(cID, cFirst_name, cLast_name, cEmail, cPassword) \r\n"
									+ "VALUES (cID_seq.NEXTVAL, ?, ?, ?, ?)");
			
			
			ps.setString(1, c.getcFirst_name());
			ps.setString(2, c.getcLast_name());
			ps.setString(3, c.getcEmail());
			ps.setString(4, c.getcPassword());
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
		
	}

	@Override
	public Client getClient(String email, String password) {
		
		Client c=new Client();
		try{
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select * from customers where cEmail= ? AND cPassword = ? ");
			ps.setString(1,email);
			ps.setString(2,password);
	
	
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				c.setcID(rs.getInt(1));
				c.setcFirst_name(rs.getString(2));
				c.setcLast_name(rs.getString(3));
				c.setcEmail(rs.getString(4));
				c.setcPassword(rs.getString(5));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return c;
		}
		
	}


