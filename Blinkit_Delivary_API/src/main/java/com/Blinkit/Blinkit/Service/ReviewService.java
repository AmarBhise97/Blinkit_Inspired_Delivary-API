package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.ReviewDto;
import com.Blinkit.Blinkit.Entity.Review;
import com.Blinkit.Blinkit.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewrepo;
	
	public ReviewService(ReviewRepository reviewrepo) {
		this.reviewrepo=reviewrepo;
	}
	
	public Review addreview(Review review) {
		
		return reviewrepo.save(review);
	}
	
	public List<ReviewDto> getallreview(){
		
		return reviewrepo.findAll().stream()
				.map((rev)->{
					ReviewDto review = new ReviewDto();
					review.setComment(rev.getComment());
					review.setReviewid(rev.getReviewid());
					review.setProductname(rev.getProductname());
					review.setReview_time(rev.getReview_time());
					review.setRating(rev.getRating());
					
					
					review.setItemid(rev.getOrder().getItemid());
					review.setPrice(rev.getOrder().getPrice());
					review.setItemname(rev.getOrder().getItemname());
					review.setOrder_left_time(rev.getOrder().getOrder_left_time());
					
					review.setUserid(rev.getUser().getUserid());
					review.setUsername(rev.getUser().getUsername());
					review.setLoging_time(rev.getUser().getLoging_time());
					
					
					return review;
				})
				.collect(Collectors.toList());
	}
	

}
