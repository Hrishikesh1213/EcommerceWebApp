package com.dbmsproject.EcommerceWebApp;

public class Cards {
	
	private int cardID;
	private int cID;
	private String cardNo;
	private String pin;
	
	public Cards(int cardID, int cID, String cardNo, String pin) {
		super();
		this.cardID = cardID;
		this.cID = cID;
		this.cardNo = cardNo;
		this.pin = pin;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Cards [cardID=" + cardID + ", cID=" + cID + ", cardNo=" + cardNo + "]";
	}
	
	

}
