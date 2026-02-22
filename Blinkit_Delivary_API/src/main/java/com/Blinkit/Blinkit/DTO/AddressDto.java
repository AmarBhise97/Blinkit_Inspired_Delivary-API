package com.Blinkit.Blinkit.DTO;

import java.util.List;

public class AddressDto {
	int addressid;
	int pincode;
	String city;
	String district;
	String state;
	
	int userid;
	String username;
	
	List<Order3> order;
	

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
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

	public List<Order3> getOrder() {
		return order;
	}

	public void setOrder(List<Order3> order) {
		this.order = order;
	}
	
	
	
	

}
