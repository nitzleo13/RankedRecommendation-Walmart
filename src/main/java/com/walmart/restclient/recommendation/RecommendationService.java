package com.walmart.restclient.recommendation;

import com.walmart.exception.RestServiceException;


public interface RecommendationService {
	 
	public Integer[] getProductRecommendation(Integer firstProductId) throws RestServiceException;

}
