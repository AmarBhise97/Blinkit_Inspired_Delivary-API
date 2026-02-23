package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.ReviewDto;
import com.Blinkit.Blinkit.Entity.Review;
import com.Blinkit.Blinkit.Exception.BadRequestException;
import com.Blinkit.Blinkit.Service.ReviewService;

@RestController
@CrossOrigin(allowedHeaders="*")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewservice;
	
	
	
	@PostMapping("/addreview")
	public ResponseEntity<Review> addreview(@RequestBody Review review) throws BadRequestException {
		if(review.getProductna()==null||review.getProductna().isBlank()) {
			throw new BadRequestException("please enter the valid ProductName..........");
		}
		if(review.getRating()==null||review.getRating().isBlank()) {
			throw new BadRequestException("please enter the valid Rating.........");
		}
		if(review.getUser()==null||review.getUser().getUserid()<=0) {
			throw new BadRequestException("please enter the valid User");
			
		}
		if(review.getOrder()==null|| review.getOrder().getProductid()<=0) {
			throw new BadRequestException("please enter the valid ProductId");
		}
		return reviewservice.addreview(review);
	}
	
	@GetMapping("/getallreview")
	public List<ResponseEntity<ReviewDto>> getallreview(@RequestParam(value="num")int num,@RequestParam(value="size")int size){
		
		return reviewservice.getallreview(num,size);
	}

}
