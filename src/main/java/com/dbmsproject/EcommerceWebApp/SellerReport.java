package com.dbmsproject.EcommerceWebApp;

public class SellerReport {

	private int sID;
	private String date;
	private int amount;
	private int count;
	public SellerReport(int sID, String date, int amount, int count) {
		super();
		this.sID = sID;
		this.date = date;
		this.amount = amount;
		this.count = count;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	


}
