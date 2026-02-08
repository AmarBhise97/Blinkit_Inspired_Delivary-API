package com.Blinkit.Blinkit.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

public class Order2Dto {
	
	int Productid;
	String Productname;
	double Productprice;
	
	@CreationTimestamp
    private LocalDateTime order_left_time;
	
	
	
	public LocalDateTime getOrder_left_time() {
		return order_left_time;
	}
	public void setOrder_left_time(LocalDateTime order_left_time) {
		this.order_left_time = order_left_time;
	}
	public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public double getProductprice() {
		return Productprice;
	}
	public void setProductprice(double productprice) {
		Productprice = productprice;
	}
	
	
	

}
