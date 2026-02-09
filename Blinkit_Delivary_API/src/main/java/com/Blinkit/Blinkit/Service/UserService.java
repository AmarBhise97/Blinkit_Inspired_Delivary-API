package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.Address2Dto;
import com.Blinkit.Blinkit.DTO.Order2Dto;
import com.Blinkit.Blinkit.DTO.Review2Dto;
import com.Blinkit.Blinkit.DTO.UserDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private UserRepository userrepo;

	public UserService(UserRepository userrepo) {
		this.userrepo = userrepo;
	}

	public User1 adduser(User1 user1) {
		return userrepo.save(user1);

	}

	public UserDto getbyidd(int userid) throws Exception {

		return userrepo.findById(userid).map((user) -> {
			UserDto userd = new UserDto();

			userd.setUserid(user.getUserid());
			userd.setUsername(user.getUsername());
			userd.setLoging_time(user.getLoging_time());

			List<Address2Dto> address = user.getAddress().stream().map((add) -> {
				Address2Dto userdto = new Address2Dto();

				userdto.setPincode(add.getPincode());
				userdto.setCity(add.getCity());
				userdto.setState(add.getState());

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
			return userd;
		}).orElseThrow(() -> new Exception("not the valid "));

	}

//	@Transactional
//	public UserDto deletebyid(int userid) throws Exception {
//		User1 user = userrepo.findById(userid).orElseThrow(() -> new Exception("user not found...!"));
//		UserDto us = new UserDto();
//		us.setUserid(user.getUserid());
//
//		List<Address2Dto> address2 = user.getAddress().stream().map((address) -> {
//			Address2Dto add = new Address2Dto();
//			add.setCity(address.getCity());
//			add.setPincode(address.getPincode());
//			add.setState(address.getState());
//
//			return add;
//		}).collect(Collectors.toList());
//		List<Order2Dto> order = user.getOrder().stream().map((ord) -> {
//			Order2Dto order1 = new Order2Dto();
//			order1.setProductid(ord.getProductid());
//			order1.setProductname(ord.getPoductname());
//			order1.setProductprice(ord.getProductprice());
//
//			order1.setOrder_left_time(ord.getOrder_left_time());
//
//			return order1;
//
//		}).collect(Collectors.toList());
//		List<Review2Dto> review1 = user.getReview().stream().map((rev) -> {
//			Review2Dto review = new Review2Dto();
//			review.setComment(rev.getComment());
//			review.setReviewid(rev.getReviewid());
//
//			review.setRating(rev.getRating());
//			review.setProductna(rev.getProductna());
//			review.setReview_time(rev.getReview_time());
//
//			return review;
//		}).collect(Collectors.toList());
//		us.setOrder2(order);
//		us.setReview(review1);
//		us.setAddress(address2);
//		userrepo.deleteById(userid);
//		return us;
//	}
	
	
	public List<UserDto> getall() {
		return userrepo.findAll().stream().map((user) -> {
			UserDto ud = new UserDto();
			ud.setUserid(user.getUserid());
			ud.setUsername(user.getUsername());
			ud.setLoging_time(user.getLoging_time());

			List<Address2Dto> address2 = user.getAddress().stream().map((address) -> {
				Address2Dto add = new Address2Dto();
				add.setCity(address.getCity());
				add.setPincode(address.getPincode());
				add.setState(address.getState());

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
