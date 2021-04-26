package com.dbmsproject.EcommerceWebApp;

public class Review {

	private int pID;
	private int cID;
	private int sID;
	private int rating;
	private String review;
	public Review(int pID, int cID, int sID, int rating, String review) {
		super();
		this.pID = pID;
		this.cID = cID;
		this.sID = sID;
		this.rating = rating;
		this.review = review;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Review [pID=" + pID + ", cID=" + cID + ", sID=" + sID + ", rating=" + rating + ", review=" + review
				+ "]";
	}
	
}
