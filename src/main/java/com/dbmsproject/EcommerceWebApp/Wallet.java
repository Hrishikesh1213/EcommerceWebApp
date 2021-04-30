package com.dbmsproject.EcommerceWebApp;

public class Wallet {

	private int cID;
	private String name;
	private String password;
	private float amount;
	private int points;
	public Wallet(int cID, String name, String password, float amount, int points) {
		super();
		this.cID = cID;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.points = points;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
	
}
