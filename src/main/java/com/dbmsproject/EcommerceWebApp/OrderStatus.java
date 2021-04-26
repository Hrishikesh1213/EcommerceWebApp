package com.dbmsproject.EcommerceWebApp;

public class OrderStatus {

	private String pname;
	private String pdescription;
	private String sname;
	private String orderdate;
	private int tID;
	private String phno;
	private String address;
	private String transtype;
	private String delivery_status;
	private int cost;
	private int quantity;
	private int shipping_charge;
	public OrderStatus(String pname, String pdescription, String sname, String orderdate, int tID, String phno,
			String address, String transtype, String delivery_status, int cost, int quantity, int shipping_charge) {
		super();
		this.pname = pname;
		this.pdescription = pdescription;
		this.sname = sname;
		this.orderdate = orderdate;
		this.tID = tID;
		this.phno = phno;
		this.address = address;
		this.transtype = transtype;
		this.delivery_status = delivery_status;
		this.cost = cost;
		this.quantity = quantity;
		this.shipping_charge = shipping_charge;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getShipping_charge() {
		return shipping_charge;
	}
	public void setShipping_charge(int shipping_charge) {
		this.shipping_charge = shipping_charge;
	}
	@Override
	public String toString() {
		return "OrderStatus [pname=" + pname + ", pdescription=" + pdescription + ", sname=" + sname + ", orderdate="
				+ orderdate + ", tID=" + tID + ", phno=" + phno + ", address=" + address + ", transtype=" + transtype
				+ ", delivery_status=" + delivery_status + ", cost=" + cost + ", quantity=" + quantity
				+ ", shipping_charge=" + shipping_charge + "]";
	}
	
	
	

}
