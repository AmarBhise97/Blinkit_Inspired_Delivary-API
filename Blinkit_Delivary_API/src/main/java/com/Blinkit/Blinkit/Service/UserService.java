package com.Blinkit.Blinkit.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.Address2Dto;
import com.Blinkit.Blinkit.DTO.Order2Dto;
import com.Blinkit.Blinkit.DTO.Review2Dto;
import com.Blinkit.Blinkit.DTO.UserDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Entity.Order1;
import com.Blinkit.Blinkit.Entity.Review;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Exception.BadRequestException;
import com.Blinkit.Blinkit.Repository.AddressRepository;
import com.Blinkit.Blinkit.Repository.OrderRepository;
import com.Blinkit.Blinkit.Repository.ReviewRepository;
import com.Blinkit.Blinkit.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private UserRepository userrepo;

	@Autowired
	private AddressRepository adrepo;

	@Autowired
	private OrderRepository odrepo;

	@Autowired
	private ReviewRepository rrepo;

	public UserService(UserRepository userrepo) {
		this.userrepo = userrepo;
	}

//	public UserDto adduser(UserDto user1) {
//
//	    if (user1.getAddress() != null) {
//	        for (Address address : user1.getAddress()) {
//	            address.setUser(user1);  // 🔥 IMPORTANT LINE
//	        }
//	    }
//
//	   
//
//	    return userrepo.save(user1);
//	}

	public ResponseEntity<UserDto>    adduser(UserDto userDto) {

		User1 user = new User1();
		user.setUsername(userDto.getUsername());
		user.setUserid(userDto.getUserid());
		user.setUser_number(userDto.getUser_number());

		List<Address> addresses = new ArrayList<>();

		if (userDto.getAddress() != null) {
			for (Address2Dto addrDto : userDto.getAddress()) {

				Address address = new Address();
				address.setCity(addrDto.getCity());
				address.setDistrict(addrDto.getDistrict());
				address.setState(addrDto.getState());
				address.setPincode(addrDto.getPincode());
				address.setAddressid(addrDto.getAddressid());

				address.setUser(user); // 🔥 IMPORTANT

				addresses.add(address);
			}
		}

		user.setAddress(addresses);

		User1 savedUser = userrepo.save(user);

		// Convert back to DTO (optional)
		userDto.setUserid(savedUser.getUserid());

		return new ResponseEntity<UserDto>(userDto,HttpStatus.CREATED);
	}

	public ResponseEntity<UserDto> getbyidd(int userid) throws Exception {

		return userrepo.findById(userid).map((user) -> {
			UserDto userd = new UserDto();

			userd.setUserid(user.getUserid());
			userd.setUsername(user.getUsername());
			userd.setLoging_time(user.getLoging_time());

			List<Address2Dto> address = user.getAddress().stream().map((add) -> {
				Address2Dto userdto = new Address2Dto();
				
                userdto.setAddressid(add.getAddressid());
				userdto.setPincode(add.getPincode());
				userdto.setCity(add.getCity());
				userdto.setState(add.getState());
				userdto.setDistrict(add.getDistrict());

				return userdto;
			}).collect(Collectors.toList());
			List<Order2Dto> order = user.getOrder().stream().map((or) -> {

				Order2Dto order1 = new Order2Dto();
				order1.setProductid(or.getProductid());
				order1.setProductname(or.getPoductname());
				order1.setProductprice(or.getProductprice());

				order1.setOrder_left_time(or.getOrder_left_time());
				return order1;
			}).collect(Collectors.toList());
			List<Review2Dto> review1 = user.getReview().stream().map((rev) -> {
				Review2Dto review = new Review2Dto();
				review.setComment(rev.getComment());
				review.setReviewid(rev.getReviewid());

				review.setRating(rev.getRating());
				review.setProductna(rev.getProductna());
				review.setReview_time(rev.getReview_time());

				return review;
			}).collect(Collectors.toList());

			userd.setAddress(address);
			userd.setOrder2(order);
			userd.setReview(review1);
			return  new ResponseEntity<UserDto>(userd,HttpStatus.FOUND);
		}).orElseThrow(() -> new BadRequestException("not the valid user -> Userid please enter valid Userid  "+userid));

	}

	public String deletebyid(int userid) throws Exception {
		// User1 user = userrepo.findById(userid).orElseThrow(() -> new Exception("user
		// not found...!"));

//		 User1 user=userrepo.findById(userid).get();
//		 
//		 
//			 List<Address> addlist=user.getAddress();
//			 List<Order1> orderlist=user.getOrder(); 
//			 List<Review> reviewList=  user.getReview();
//			 
//			 
//			 
//			 List<Integer> addid= addlist.stream().map((i)->(i.getPincode())).collect(Collectors.toList());
//			 
//			 List<Integer> rewid= reviewList.stream().map((i)->(i.getReviewid())).collect(Collectors.toList());
//			 
//			 
//			 
//			 List<Integer> orderid= orderlist.stream().map((i)->(i.getProductid())).collect(Collectors.toList());
//
//			 
//			 
//			 System.out.println("deleting the reviews....");
//			 rewid.stream().forEach((id)->{
//				 adrepo.deleteById(id);
//			 });
//			 
//			 
//			 System.out.println("deleting the orders.......");
//			 orderid.stream().forEach((id)->{
//				 adrepo.deleteById(id);
//			 });
//			 
//			 System.out.println("deleting the addresses.....");
//			 addid.stream().forEach((id)->{
//				 adrepo.deleteById(id);
//			 });
//	
//			 System.out.println("deleting:"+user.getUsername());
//			 userrepo.deleteById(userid);

		rrepo.deleteById(null);

		return "deletion successfull";
	}

	public List<UserDto> getall() {
		return userrepo.findAll().stream().map((user) -> {
			UserDto ud = new UserDto();
			ud.setUserid(user.getUserid());
			ud.setUsername(user.getUsername());
			ud.setLoging_time(user.getLoging_time());

			List<Address2Dto> address2 = user.getAddress().stream().map((address) -> {
				Address2Dto add = new Address2Dto();
				add.setAddressid(address.getAddressid());
				add.setCity(address.getCity());
				add.setPincode(address.getPincode());
				add.setState(address.getState());
				add.setDistrict(address.getDistrict());

				return add;
			}).collect(Collectors.toList());

			List<Order2Dto> order = user.getOrder().stream().map((ord) -> {
				Order2Dto order1 = new Order2Dto();
				order1.setProductid(ord.getProductid());
				order1.setProductname(ord.getPoductname());
				order1.setProductprice(ord.getProductprice());

				order1.setOrder_left_time(ord.getOrder_left_time());

				return order1;

			}).collect(Collectors.toList());
			List<Review2Dto> review1 = user.getReview().stream().map((rev) -> {
				Review2Dto review = new Review2Dto();
				review.setComment(rev.getComment());
				review.setReviewid(rev.getReviewid());

				review.setRating(rev.getRating());
				review.setProductna(rev.getProductna());
				review.setReview_time(rev.getReview_time());

				return review;
			}).collect(Collectors.toList());
			ud.setAddress(address2);
			ud.setOrder2(order);
			ud.setReview(review1);

			return ud;
		}).collect(Collectors.toList());
	}

}
