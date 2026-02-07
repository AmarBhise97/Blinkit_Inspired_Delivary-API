package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.Address2Dto;
import com.Blinkit.Blinkit.DTO.Order2Dto;
import com.Blinkit.Blinkit.DTO.Review2Dto;
import com.Blinkit.Blinkit.DTO.UserDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Repository.UserRepository;

@Service
public class UserService {
	
	
	private UserRepository userrepo;
	
	public UserService(UserRepository userrepo) {
		this.userrepo=userrepo;
	}
	
	public User1 adduser(User1 user1) {
		return userrepo.save(user1);
		
	}
	public List<UserDto> getall(){
		return userrepo.findAll().stream()
				.map((user)->{
					UserDto ud = new UserDto();
					ud.setUserid(user.getUserid());
					ud.setUsername(user.getUsername());
					ud.setLoging_time(user.getLoging_time());
					
					List<Address2Dto> address2 =user.getAddress().stream()
							.map((address)->{
								Address2Dto add = new Address2Dto();
								add.setCity(address.getCity());
								add.setPincode(address.getPincode());
								add.setState(address.getState());
								
								return add;
							})
							.collect(Collectors.toList());
					
					List<Order2Dto> order = user.getOrder().stream()
							.map((ord)->{
							Order2Dto order1= new Order2Dto();
							order1.setItemid(ord.getItemid());
							order1.setItemname(ord.getItemname());
							order1.setPrice(ord.getPrice());
							order1.setOrder_left_time(ord.getOrder_left_time());
							
							
							return order1;
							
							}).collect(Collectors.toList());
					List<Review2Dto> review1=user.getReview().stream()
							.map((rev)->{
								Review2Dto review = new Review2Dto();
								review.setComment(rev.getComment());
								review.setReviewid(rev.getReviewid());
								review.setProductname(rev.getProductname());
								review.setRating(rev.getRating());
								review.setReview_time(rev.getReview_time());
								
								
								return review;
							})
							.collect(Collectors.toList());
					ud.setAddress(address2);
					ud.setOrder2(order);
					ud.setReview(review1);
					
					return ud;
				})
				.collect(Collectors.toList());
	}
	

}
