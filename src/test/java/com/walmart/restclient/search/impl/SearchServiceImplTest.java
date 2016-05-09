package com.walmart.restclient.search.impl;

import static org.junit.Assert.*;
import junit.framework.*;

import org.junit.Before;
import org.junit.Test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.walmart.exception.RestServiceException;
import com.walmart.restclient.search.model.SearchResponse;
import com.walmart.restclient.search.impl.SearchServiceImpl.*;
public class SearchServiceImplTest {
	
	SearchServiceImpl srch;
	private String product="Palmolive";
	  RestTemplate restTemplate;
	@Before
	public void before(){
		srch= new SearchServiceImpl();
		restTemplate = new RestTemplate();

	}
	@Test(expected =RestServiceException.class)
	public void testGetProductDetails_NullCorrectness() throws RestServiceException{
		srch.getProductDetails(null);
	
    }
	
	@Test(expected =RestServiceException.class)
	public void testGetProductDetails_EmptyCorrectness() throws RestServiceException{
		srch.getProductDetails("");

	}
	//Search test based on a specific product; ensures correctness of api
	@Test
	public void testGetProductDetails_Match() throws RestServiceException{
	Integer actual=srch.getProductDetails(product);
	SearchResponse srchResp=restTemplate.getForObject("http://api.walmartlabs.com/v1/search?format=json&query="+product+"&apiKey=qrjatewj94vc24aqtnn6vfkg", SearchResponse.class);
	Integer expected=srchResp.getItems().get(0).getItemId();
	assertEquals(expected,actual);
	}
	
	
	@Test(expected =RestServiceException.class)
	public void testGetProductDetails_NoMatchingRecord() throws RestServiceException{
		srch.getProductDetails("adkfnsnd%%$");
	}
	
	
	
	
	//******************************************************************************Negative test**************************************************
	
	//Used to ensure the api calls don't match because products are different
	//@Test
	//public void testGetProductDetails_NoMatch() throws RestServiceException{
	//Integer actual=srch.getProductDetails(product);
	//SearchResponse srchResp=restTemplate.getForObject("http://api.walmartlabs.com/v1/search?format=json&query=palm&apiKey=qrjatewj94vc24aqtnn6vfkg", SearchResponse.class);
	//Integer expected=srchResp.getItems().get(0).getItemId();
	//assertEquals(expected,actual);
//	}
	
	
	
	
}