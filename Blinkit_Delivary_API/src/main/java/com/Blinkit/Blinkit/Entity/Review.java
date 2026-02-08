package com.Blinkit.Blinkit.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int reviewid;
	
	String productna;
	String rating;
	String comment;
	
	@JoinColumn(name="user")
	@ManyToOne
	User1 user;
	
	@JoinColumn
	@ManyToOne
	private Order1 order;
	
	@CreationTimestamp
	private LocalDateTime review_time;
	
	
	public LocalDateTime getReview_time() {
		return review_time;
	}
	public void setReview_time(LocalDateTime review_time) {
		this.review_time = review_time;
	}
	public Order1 getOrder() {
		return order;
	}
	public void setOrder(Order1 order) {
		this.order = order;
	}
	public User1 getUser() {
		return user;
	}
	public void setUser(User1 user) {
		this.user = user;
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
	public String getProductna() {
		return productna;
	}
	public void setProductna(String productna) {
		this.productna = productna;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	

}
