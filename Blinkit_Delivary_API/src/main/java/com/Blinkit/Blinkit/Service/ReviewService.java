package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<Review> addreview(Review review) {
		
		return new ResponseEntity<Review>(reviewrepo.save(review) ,HttpStatus.CREATED);
	}
	
	public List<ResponseEntity<ReviewDto>> getallreview(){
		
		return reviewrepo.findAll().stream()
				.map((rev)->{
					ReviewDto review = new ReviewDto();
					review.setComment(rev.getComment());
					review.setReviewid(rev.getReviewid());
					review.setProductna(rev.getProductna());
					review.setReview_time(rev.getReview_time());
					review.setRating(rev.getRating());
					
					
					review.setProductid(rev.getOrder().getProductid());
					review.setProductprice(rev.getOrder().getProductprice());
					review.setProductname(rev.getOrder().getPoductname());
					review.setOrder_left_time(rev.getOrder().getOrder_left_time());
					
					review.setUserid(rev.getUser().getUserid());
					review.setUsername(rev.getUser().getUsername());
					review.setLoging_time(rev.getUser().getLoging_time());
					
					
					return new ResponseEntity<ReviewDto>(review,HttpStatus.CREATED);
				})
				.collect(Collectors.toList());
	}
	

}
