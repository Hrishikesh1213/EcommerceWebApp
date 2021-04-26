package com.dbmsproject.EcommerceWebApp;

public interface MyProvider {
	
	String url=	"jdbc:oracle:thin:@localhost:1521:dbsproject";	//	"jdbc:mysql://127.0.0.1:3306/dbmsproject"
	String username= "c##dbsproject";							//	"root"
	String password= "dbsproject";								//	"5422"
	String loadclass = "oracle.jdbc.driver.OracleDriver";		//	"com.mysql.jdbc.Driver"

}
