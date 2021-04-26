package com.dbmsproject.EcommerceWebApp;

public class Cart {
	
	private int pID;
	private int cID;
	private int sID;
	private int price;
	private int quantity;
	public Cart(int pID, int cID, int sID, int price, int quantity) {
		super();
		this.pID = pID;
		this.cID = cID;
		this.sID = sID;
		this.price = price;
		this.quantity = quantity;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [pID=" + pID + ", cID=" + cID + ", sID=" + sID + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	

}
