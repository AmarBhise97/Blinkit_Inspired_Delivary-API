package com.Blinkit.Blinkit.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;




@Entity

public class Order1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int productid;
	String poductname;
	double productprice;
	
	
	@JoinColumn(name = "user")
	@ManyToOne
	User1 user;
	
	@JoinColumn(name = "address")
	@ManyToOne
	Address address;
	
	@OneToMany(mappedBy="order")
	private List<Review> review;
	
	@CreationTimestamp
    private LocalDateTime order_left_time;
	
	
	
	
	public LocalDateTime getOrder_left_time() {
		return order_left_time;
	}

	public void setOrder_left_time(LocalDateTime order_left_time) {
		this.order_left_time = order_left_time;
	}

	

	

	
	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPoductname() {
		return poductname;
	}

	public void setPoductname(String poductname) {
		this.poductname = poductname;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	

}
