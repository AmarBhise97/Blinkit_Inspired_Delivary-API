package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

public class OrderDto {
	
	int productid;
	String productname;
	double productprice;
	@CreationTimestamp
    private LocalDateTime order_left_time;
	

	
	int userid;
	String username;
	@CreationTimestamp
	private LocalDateTime  loging_time;
	
	int addressid;
	int pincode;
	String city;
	String district;
	String state;
	
	List<Review3dto> review;
	
	
	
	
	
	public List<Review3dto> getReview() {
		return review;
	}
	public void setReview(List<Review3dto> review) {
		this.review = review;
	}
	public LocalDateTime getLoging_time() {
		return loging_time;
	}
	public void setLoging_time(LocalDateTime loging_time) {
		this.loging_time = loging_time;
	}
	
	public LocalDateTime getOrder_left_time() {
		return order_left_time;
	}
	public void setOrder_left_time(LocalDateTime order_left_time) {
		this.order_left_time = order_left_time;
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
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	
	
	
	
	
	
	
	
	
}
