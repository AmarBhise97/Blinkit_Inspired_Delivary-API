package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;



public class UserDto {
	
	int userid;
	String username;
	String user_number;
	@CreationTimestamp
	private LocalDateTime  loging_time;
	
	List<Address2Dto> address;
	List<Order2Dto> order2;
	List<Review2Dto> review;
	
	

	public LocalDateTime getLoging_time() {
		return loging_time;
	}

	public void setLoging_time(LocalDateTime loging_time) {
		this.loging_time = loging_time;
	}

	public List<Review2Dto> getReview() {
		return review;
	}

	public void setReview(List<Review2Dto> review) {
		this.review = review;
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

	public List<Address2Dto> getAddress() {
		return address;
	}

	public void setAddress(List<Address2Dto> address) {
		this.address = address;
	}

	public List<Order2Dto> getOrder2() {
		return order2;
	}

	public void setOrder2(List<Order2Dto> order2) {
		this.order2 = order2;
	}

	public String getUser_number() {
		return user_number;
	}

	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	
	

	
	
	

}
