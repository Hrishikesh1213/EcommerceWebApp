package com.dbmsproject.EcommerceWebApp;

public class PaymentsType {

	private int cID;
	private String transtype;
	
	public PaymentsType() {
		super();
	}

	public PaymentsType(int cID, String transtype) {
		super();
		this.cID = cID;
		this.transtype = transtype;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	@Override
	public String toString() {
		return "PaymentsType [cID=" + cID + ", transtype=" + transtype + "]";
	}
	
	
	

}
