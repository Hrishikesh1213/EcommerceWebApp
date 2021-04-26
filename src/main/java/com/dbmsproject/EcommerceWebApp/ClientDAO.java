package com.dbmsproject.EcommerceWebApp;

public interface ClientDAO {

	public int insertClient(Client c);
	public Client getClient(String username,String password);
	
}
