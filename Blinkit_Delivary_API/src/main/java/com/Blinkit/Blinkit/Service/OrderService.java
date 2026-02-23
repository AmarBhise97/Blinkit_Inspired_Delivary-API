package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.OrderDto;
import com.Blinkit.Blinkit.DTO.Review3dto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Entity.Order1;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Exception.ResourceNotFoundException;
import com.Blinkit.Blinkit.Repository.OrderRepository;
import com.Blinkit.Blinkit.Repository.UserRepository;

@Service
public class OrderService {
	
	
	private OrderRepository orderrepo;
	
	@Autowired
	private UserRepository repo;
	public OrderService(OrderRepository orderrepo) {
		
		this.orderrepo=orderrepo;
	}
	
	public ResponseEntity<Order1> addorder(Order1 order1) throws Exception {
	     User1 u1=repo.findById(order1.getUser().getUserid()).get();
	     List<Address> list=u1.getAddress();
         List<Integer> list_p=list.stream().map((i)->(i.getPincode())).collect(Collectors.toList());
                if(list_p.contains(order1.getAddress().getPincode())==false) {
                	  throw new Exception("wrong addresss....");
                }
              
                return new ResponseEntity<Order1>(orderrepo.save(order1),HttpStatus.CREATED);
	}
	
	public List<ResponseEntity<OrderDto>> getorder(int num,int size){
		Pageable pageable =PageRequest.of(num, size);
		return orderrepo.findAll(pageable).stream()
				.map((order)->{
					OrderDto orderdto = new OrderDto();
					orderdto.setAddressid(order.getProductid());
					orderdto.setState(order.getAddress().getState());
					orderdto.setPincode(order.getAddress().getPincode());
					orderdto.setCity(order.getAddress().getCity());
					orderdto.setDistrict(order.getAddress().getDistrict());
					
					
					orderdto.setProductid(order.getProductid());
					orderdto.setProductname(order.getPoductname());
					orderdto.setProductprice(order.getProductprice());
					orderdto.setOrder_left_time(order.getOrder_left_time());
					
					orderdto.setUserid(order.getUser().getUserid());
					orderdto.setUsername(order.getUser().getUsername());
					orderdto.setLoging_time(order.getUser().getLoging_time());
					
					
					
					
					List<Review3dto> rev =order.getReview().stream()
							.map((review)->{
								Review3dto revi=new Review3dto();
								revi.setProductna(review.getProductna());
								revi.setRating(review.getRating());
								revi.setReview_time(revi.getReview_time());
								revi.setReviewid(review.getReviewid());
								
								return revi;
							})
							.collect(Collectors.toList());
					
					
					orderdto.setReview(rev);
					return new ResponseEntity<OrderDto>(orderdto,HttpStatus.FOUND);
					
				})
				.collect(Collectors.toList());
	}
	public ResponseEntity<OrderDto> getbyorder(int productid) throws Exception {
		return orderrepo.findById(productid).map((or)->{
			OrderDto order = new OrderDto();
			order.setAddressid(or.getAddress().getAddressid());
			order.setState(or.getAddress().getState());
			order.setPincode(or.getAddress().getPincode());
			order.setCity(or.getAddress().getCity());
			order.setDistrict(or.getAddress().getDistrict());
			
			
			order.setProductid(or.getProductid());
			order.setProductname(or.getPoductname());
			order.setProductprice(or.getProductprice());
			order.setOrder_left_time(or.getOrder_left_time());
			
			order.setUserid(or.getUser().getUserid());
			order.setUsername(or.getUser().getUsername());
			order.setLoging_time(or.getUser().getLoging_time());
			
			List<Review3dto> rev =order.getReview().stream()
					.map((review)->{
						Review3dto revi=new Review3dto();
						revi.setProductna(review.getProductna());
						revi.setRating(review.getRating());
						revi.setReview_time(revi.getReview_time());
						revi.setReviewid(review.getReviewid());
						
						return revi;
					})
					.collect(Collectors.toList());
			
			
			order.setReview(rev);
			
			return new ResponseEntity<OrderDto>(order,HttpStatus.FOUND);
		})  .orElseThrow(() -> new ResourceNotFoundException(
                "Order not found with productId: " + productid));
	}

}
