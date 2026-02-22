package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.OrderDto;
import com.Blinkit.Blinkit.Entity.Order1;
import com.Blinkit.Blinkit.Exception.BadRequestException;
import com.Blinkit.Blinkit.Service.OrderService;


@RestController
@CrossOrigin(allowedHeaders="*")
public class OrderController {
	
	private OrderService orderservice;
	
	public OrderController(OrderService orderservice) {
		
		this.orderservice=orderservice;
	}
	
	@PostMapping("/addorder")
	public ResponseEntity<Order1> addorder(@RequestBody Order1 Order1) throws Exception {
		if(Order1.getPoductname()==null|| Order1.getPoductname().isBlank()) {
			throw new BadRequestException("Product is empty....");
		}
		if(Order1.getProductprice()<1 ) {
			throw new BadRequestException("please enter the valid payment");
		}
		if(Order1.getUser()==null|| Order1.getUser().getUserid()<=0) {
			throw new BadRequestException("Please enter the valid userid");
		}
		if(Order1.getAddress()==null|| Order1.getAddress().getAddressid()<=0) {
			throw new BadRequestException("please enter the valid pincode");
		}
		return orderservice.addorder(Order1);
	}
	
	@GetMapping("/getorder")
	public List<ResponseEntity<OrderDto>> getorder(){
		return orderservice.getorder();
	}
	
	@GetMapping("/getbyorderid/{productid}")
	public ResponseEntity<OrderDto> getbyorderid(@PathVariable ("productid") int productid) throws Exception{
		
		return orderservice.getbyorder(productid);
	}
	
}
