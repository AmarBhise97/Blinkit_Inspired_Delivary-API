package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.ReviewDto;
import com.Blinkit.Blinkit.Entity.Review;
import com.Blinkit.Blinkit.Service.ReviewService;

@RestController
@CrossOrigin(allowedHeaders="*")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewservice;
	
	
	
	@PostMapping("/addreview")
	public Review addreview(@RequestBody Review review) {
		
		return reviewservice.addreview(review);
	}
	
	@GetMapping("/getallreview")
	public List<ReviewDto> getallreview(){
		
		return reviewservice.getallreview();
	}

}
