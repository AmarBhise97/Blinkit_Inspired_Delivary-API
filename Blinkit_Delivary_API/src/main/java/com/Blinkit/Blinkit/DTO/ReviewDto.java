package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class ReviewDto {
	
	int reviewid;
	String productna;
	String rating;
	String comment;
	@CreationTimestamp
	private LocalDateTime review_time;
	
	int userid;
	String username;
	
	@CreationTimestamp
	private LocalDateTime  loging_time;
	
	int productid;
	String productname;
	double productprice;
	@CreationTimestamp
    private LocalDateTime order_left_time;
	
	
	
	
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
	public LocalDateTime getReview_time() {
		return review_time;
	}
	public void setReview_time(LocalDateTime review_time) {
		this.review_time = review_time;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
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
	public String getProductna() {
		return productna;
	}
	public void setProductna(String productna) {
		this.productna = productna;
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
	
	

}
