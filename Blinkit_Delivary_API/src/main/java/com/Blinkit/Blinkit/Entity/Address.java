package com.Blinkit.Blinkit.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Address {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int pincode;
	String city;
	String district;
	String state;
	
	
	@OneToMany(mappedBy="address")
	private List<Order1> order;
	
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User1 user;


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


	public List<Order1> getOrder() {
		return order;
	}


	public void setOrder(List<Order1> order) {
		this.order = order;
	}


	public User1 getUser() {
		return user;
	}


	public void setUser(User1 user) {
		this.user = user;
	}


	
	
	
	
	

}
