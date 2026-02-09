package com.Blinkit.Blinkit.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name="user")
public class User1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int userid;
	String username;
	String user_number;
	
	@OneToMany(mappedBy="user" , cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order1> order;
	
	
	@OneToMany(mappedBy="user" ,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> address;

	@OneToMany(mappedBy="user" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review>review;
	
	@CreationTimestamp
	private LocalDateTime  loging_time;
	
	
	
	public LocalDateTime getLoging_time() {
		return loging_time;
	}
	public void setLoging_time(LocalDateTime loging_time) {
		this.loging_time = loging_time;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public List<Order1> getOrder() {
		return order;
	}
	public void setOrder(List<Order1> order) {
		this.order = order;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
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
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	
	
	
	
	
	

}
