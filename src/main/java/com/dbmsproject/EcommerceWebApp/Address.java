package com.dbmsproject.EcommerceWebApp;

public class Address {
	
	private int cID;
	private String name;
	private String phno;
	private String pin;
	private String hno;
	private String colony;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private String addr_type;
	public Address(int cID, String name, String phno, String pin, String hno, String colony, String landmark,
			String city, String state, String country, String addr_type) {
		super();
		this.cID = cID;
		this.name = name;
		this.phno = phno;
		this.pin = pin;
		this.hno = hno;
		this.colony = colony;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.addr_type = addr_type;
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
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddr_type() {
		return addr_type;
	}
	public void setAddr_type(String addr_type) {
		this.addr_type = addr_type;
	}
	@Override
	public String toString() {
		return "Address [cID=" + cID + ", name=" + name + ", phno=" + phno + ", pin=" + pin + ", hno=" + hno
				+ ", colony=" + colony + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", country="
				+ country + ", addr_type=" + addr_type + "]";
	}
	public String getPrimaryKey() {
		return cID+"~"+name+"~"+phno+"~"+addr_type;
	}
	
	

}
