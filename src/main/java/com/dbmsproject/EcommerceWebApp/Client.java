package com.dbmsproject.EcommerceWebApp;

public class Client {
	
	private int cID;
	private String cFirst_name;
	private String cLast_name;
	private String cEmail;
	private String cPassword;
	
	public Client() {
		super();
	}
	public Client(int cID, String cFirst_name, String cLast_name, String cEmail, String cPassword) {
		super();
		this.cID = cID;
		this.cFirst_name = cFirst_name;
		this.cLast_name = cLast_name;
		this.cEmail = cEmail;
		this.cPassword = cPassword;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcFirst_name() {
		return cFirst_name;
	}
	public void setcFirst_name(String cFirst_name) {
		this.cFirst_name = cFirst_name;
	}
	public String getcLast_name() {
		return cLast_name;
	}
	public void setcLast_name(String cLast_name) {
		this.cLast_name = cLast_name;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	@Override
	public String toString() {
		return "Client [cID=" + cID + ", cFirst_name=" + cFirst_name + ", cLast_name=" + cLast_name + ", cEmail="
				+ cEmail + ", cPassword=" + cPassword + "]";
	}
	
	
	
}
