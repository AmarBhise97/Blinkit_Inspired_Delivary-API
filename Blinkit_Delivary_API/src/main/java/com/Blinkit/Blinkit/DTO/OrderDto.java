package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class OrderDto {
	
	int itemid;
	String itemname;
	double price;
	@CreationTimestamp
    private LocalDateTime order_left_time;
	

	
	int userid;
	String username;
	@CreationTimestamp
	private LocalDateTime  loging_time;
	
	
	int pincode;
	String city;
	String district;
	String state;
	
	int reviewid;
	String productname;
	String rating;
	String comment;
	@CreationTimestamp
	private LocalDateTime review_time;
	
	
	
	
	public LocalDateTime getLoging_time() {
		return loging_time;
	}
	public void setLoging_time(LocalDateTime loging_time) {
		this.loging_time = loging_time;
	}
	public LocalDateTime getReview_time() {
		return review_time;
	}
	public void setReview_time(LocalDateTime review_time) {
		this.review_time = review_time;
	}
	public LocalDateTime getOrder_left_time() {
		return order_left_time;
	}
	public void setOrder_left_time(LocalDateTime order_left_time) {
		this.order_left_time = order_left_time;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
	
}
