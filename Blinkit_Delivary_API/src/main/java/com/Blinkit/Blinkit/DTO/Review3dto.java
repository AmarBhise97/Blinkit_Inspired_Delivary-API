package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class Review3dto {
	
	int reviewid;
	String productna;
	String rating;
	String comment;
	@CreationTimestamp
	private LocalDateTime review_time;
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}
	public String getProductna() {
		return productna;
	}
	public void setProductna(String productna) {
		this.productna = productna;
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
	public LocalDateTime getReview_time() {
		return review_time;
	}
	public void setReview_time(LocalDateTime review_time) {
		this.review_time = review_time;
	}
	
	

}
