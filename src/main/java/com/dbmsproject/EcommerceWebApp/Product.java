package com.dbmsproject.EcommerceWebApp;

public class Product {
	
	
	private int pID;
	private int sID;
	private String sname;
	private String pname;
	private String description;
	private int price;
	private String image;
	private String category;
	private int quantity;
	
	public Product(int pID, int sID, String sname, String pname, String description, int price, String image,
			String category, int quantity) {
		super();
		this.pID = pID;
		this.sID = sID;
		this.sname = sname;
		this.pname = pname;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
		this.quantity = quantity;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [pID=" + pID + ", sID=" + sID + ", sname=" + sname + ", pname=" + pname + ", description="
				+ description + ", price=" + price + ", image=" + image + ", category=" + category + ", quantity="
				+ quantity + "]";
	}
	
	
	

	
	

}
