package com.dbmsproject.EcommerceWebApp;

import java.sql.*;

public class MyConnectionProvider implements MyProvider {
	
	static Connection con=null;
    public static Connection getCon(){
	    try{
		    Class.forName(loadclass);
		    con=DriverManager.getConnection(url,username,password);
	    }
	    catch(Exception e){
		    System.out.println(e);
	    }
	    return con;
    }

}
