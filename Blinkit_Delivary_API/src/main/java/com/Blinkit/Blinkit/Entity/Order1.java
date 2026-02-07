package com.Blinkit.Blinkit.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Order1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int itemid;
	String itemname;
	double price;
	
	
	@JoinColumn(name = "user")
	@ManyToOne
	User1 user;
	
	@JoinColumn(name = "address")
	@ManyToOne
	Address address;
	
	@OneToOne(mappedBy="order")
	private Review review;
	
	@CreationTimestamp
    private LocalDateTime order_left_time;
	
	
	
	
	public LocalDateTime getOrder_left_time() {
		return order_left_time;
	}

	public void setOrder_left_time(LocalDateTime order_left_time) {
		this.order_left_time = order_left_time;
	}

	public Review getReview() {
		System.out.println("****review*****"+review);
			
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
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
