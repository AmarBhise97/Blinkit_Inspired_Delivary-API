package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.OrderDto;
import com.Blinkit.Blinkit.Entity.Order1;
import com.Blinkit.Blinkit.Repository.OrderRepository;

@Service
public class OrderService {
	
	
	private OrderRepository orderrepo;
	
	public OrderService(OrderRepository orderrepo) {
		
		this.orderrepo=orderrepo;
	}
	
	public Order1 addorder(Order1 order1) {
		
	
		return orderrepo.save(order1);
	}
	
	public List<OrderDto> getorder(){
		
		return orderrepo.findAll().stream()
				.map((order)->{
					OrderDto orderdto = new OrderDto();
					orderdto.setState(order.getAddress().getState());
					orderdto.setPincode(order.getAddress().getPincode());
					orderdto.setCity(order.getAddress().getCity());
					orderdto.setDistrict(order.getAddress().getDistrict());
					
					
					orderdto.setItemid(order.getItemid());
					orderdto.setItemname(order.getItemname());
					orderdto.setPrice(order.getPrice());
					orderdto.setOrder_left_time(order.getOrder_left_time());
					
					orderdto.setUserid(order.getUser().getUserid());
					orderdto.setUsername(order.getUser().getUsername());
					orderdto.setLoging_time(order.getUser().getLoging_time());
					
					
					orderdto.setReviewid(order.getReview().getReviewid());
					orderdto.setProductname(order.getReview().getProductname());
					orderdto.setRating(order.getReview().getRating());
					orderdto.setComment(order.getReview().getComment());
					orderdto.setReview_time(order.getReview().getReview_time());
					
					
					
					
					
					return orderdto;
				})
				.collect(Collectors.toList());
	}

}
