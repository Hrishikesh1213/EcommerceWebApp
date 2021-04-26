package com.dbmsproject.EcommerceWebApp;

public class MyCart {
	
	private int pID;
	private int sID;
	private String image;
	private String pname;
	private String sname;
	private int price;
	private int quantity;
	private int cost;
	public MyCart(int pID, int sID, String image, String pname, String sname, int price, int quantity, int cost) {
		super();
		this.pID = pID;
		this.sID = sID;
		this.image = image;
		this.pname = pname;
		this.sname = sname;
		this.price = price;
		this.quantity = quantity;
		this.cost = cost;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "MyCart [pID=" + pID + ", sID=" + sID + ", image=" + image + ", pname=" + pname + ", sname=" + sname
				+ ", price=" + price + ", quantity=" + quantity + ", cost=" + cost + "]";
	}

	
	
	
}
