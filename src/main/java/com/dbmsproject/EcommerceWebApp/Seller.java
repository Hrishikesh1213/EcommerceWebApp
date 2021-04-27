package com.dbmsproject.EcommerceWebApp;

public class Seller {

	private int sID;
	private String name;
	private String address;
	private String password;
	public Seller(int sID, String name, String address, String password) {
		super();
		this.sID = sID;
		this.name = name;
		this.address = address;
		this.password = password;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
