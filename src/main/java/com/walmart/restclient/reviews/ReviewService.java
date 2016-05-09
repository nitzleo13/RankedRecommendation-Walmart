package com.walmart.restclient.reviews;

import com.walmart.exception.RestServiceException;
import com.walmart.restclient.reviews.model.ReviewResponse;



public interface ReviewService {
	  
	public ReviewResponse getProductReview(Integer ProductId) throws RestServiceException;
		
}
