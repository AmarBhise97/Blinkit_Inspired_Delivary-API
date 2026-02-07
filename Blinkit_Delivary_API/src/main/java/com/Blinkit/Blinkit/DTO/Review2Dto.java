package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class Review2Dto {

	int reviewid;
	String productname;
	String rating;
	String comment;
	@CreationTimestamp
	private LocalDateTime review_time;
	
	
	
	public LocalDateTime getReview_time() {
		return review_time;
	}
	public void setReview_time(LocalDateTime review_time) {
		this.review_time = review_time;
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
