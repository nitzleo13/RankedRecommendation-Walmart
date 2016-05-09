package com.walmart.restclient.search;

import com.walmart.exception.RestServiceException;

/**
 * 
 * @author KarthikNithya
 * 
 */
public interface SearchService {

	
/**
 * 
 * @param searchTerm
 * @return
 * @throws RestServiceException
 */
	public Integer getProductDetails(String searchTerm) throws RestServiceException;
}
