package com.walmart.restclient.reviews.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.walmart.exception.RestServiceException;
import com.walmart.restclient.recommendation.impl.RecommendationServiceImpl;
import com.walmart.restclient.reviews.model.ReviewResponse;

public class ReviewServiceImplTest {

	ReviewServiceImpl rev;
	private Integer productId;
	String url;
	RestTemplate restTemplate;

	@Before
	public void before() {
		rev = new ReviewServiceImpl();
		productId = 42386812;// of Palmolive//
		url = "http://api.walmartlabs.com/v1/reviews/42386801?apiKey=qrjatewj94vc24aqtnn6vfkg&format=json";
		restTemplate = new RestTemplate();

	}
	
	
	@Test(expected = RestServiceException.class)
	public void testGetProductReview() throws RestServiceException{
		rev.getProductReview(null);
	}
	
//	@Test(expected = RestServiceException.class)
//	public void testGetProductReview_EmptyResponse() throws RestServiceException{
//		rev.getProductReview(00000000);
//
//	}
	@Test(expected = Exception.class)
	public void testGetProductReview_NullResponse() throws Exception{
		//bug in api url "Reviews!=Review-->it will invoke Language exception
		String url = "http://api.walmartlabs.com/v1/review/42386801?apiKey=qrjatewj94vc24aqtnn6vfkg&format=json";
       restTemplate.getForObject(url, ReviewResponse.class);

//assertEquals(revResp,null);
	}
}
