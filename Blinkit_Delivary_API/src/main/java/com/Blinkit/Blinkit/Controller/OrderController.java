package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.OrderDto;
import com.Blinkit.Blinkit.Entity.Order1;

import com.Blinkit.Blinkit.Service.OrderService;


@RestController
@CrossOrigin(allowedHeaders="*")
public class OrderController {
	
	private OrderService orderservice;
	
	public OrderController(OrderService orderservice) {
		
		this.orderservice=orderservice;
	}
	
	@PostMapping("/addorder")
	public Order1 addorder(@RequestBody Order1 Order1) throws Exception {
		
		return orderservice.addorder(Order1);
	}
	
	@GetMapping("/getorder")
	public List<OrderDto> getorder(){
		return orderservice.getorder();
	}
	
}
