package com.walmart.restclient.recommendation.impl;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.walmart.exception.RestServiceException;
import com.walmart.restclient.recommendation.model.RecommendationResponse;

public class RecommendationServiceImplTest {

	RecommendationServiceImpl recom;
	private Integer productId;
	String url;
	RestTemplate restTemplate;

	@Before
	public void before() {
		recom = new RecommendationServiceImpl();
		productId = 42386812;// of Palmolive//
		url = "http://api.walmartlabs.com/v1/nbp?apiKey=qrjatewj94vc24aqtnn6vfkg&itemId=42386812";
		restTemplate = new RestTemplate();

	}

	// Product ID is null
	@Test(expected = RestServiceException.class)
	public void testGetProductRecommendation_EmptyCorrectness()
			throws RestServiceException {
		Integer id = null;
		recom.getProductRecommendation(id);
	}

	// //Product ID has no recommendation
	@Test(expected = RestServiceException.class)
	public void testGetProductRecommendation_NoRecom()
			throws RestServiceException {
		// Integer id=12ajhui2u9;
		recom.getProductRecommendation(0000000);
	}

	@Test
	public void testGetProductRecommendation_NoMatchCorrectness()
			throws RestServiceException {
		 Integer[] expectedid = new Integer[10];
		    expectedid[0] = 16381762;
			expectedid[1] = 36127964;
			expectedid[2] = 33947069;
			expectedid[3] = 16381766;
			expectedid[4] = 33947076;
			expectedid[5] = 20971289;
			expectedid[6] = 33947081;
			expectedid[7] = 21998566;
			expectedid[8] = 12166496;
			expectedid[9] = 19888049;
		
		Integer[] actualid = recom.getProductRecommendation(42386812);
		
		assertFalse(Arrays.deepEquals(expectedid, actualid));


	}

	//when number of recommendations are greater than 10
	@Test
	public void testGetProductRecommendation_MatchCorrectness()
			throws RestServiceException {	
		 Integer[] expectedid = new Integer[10];
		expectedid[0] = 34938309;
		expectedid[1] = 20971289;
		expectedid[2] = 17179303;
		expectedid[3] = 42682686;
		expectedid[4] = 12443214;
		expectedid[5] = 19514874;
		expectedid[6] = 42386794;
		expectedid[7] = 35644030;
		expectedid[8] = 42386801;
		expectedid[9] = 16565094;

		
		Integer[] actualid = recom.getProductRecommendation(42386812);
		
		for (int i = 0; i < actualid.length; i++) {
			assertEquals(expectedid[i], actualid[i]);
		}

	}
	
	@Test
	public void testGetProductRecommendation_MatchCorrectness_LessThan10()
			throws RestServiceException {				
		Integer[] expectedid = new Integer[5];
		expectedid[0] = 37332885;
		expectedid[1] = 15042526;
		expectedid[2] = 14904250;
		expectedid[3] = 7386195;
		expectedid[4] = 13722508;

		Integer[] actualid = recom.getProductRecommendation(16641592);
		
		for (int i = 0; i < actualid.length; i++) {
			assertEquals(expectedid[i], actualid[i]);
		}

	}

}
