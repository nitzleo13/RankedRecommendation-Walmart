package com.walmart.restclient.sentiment;

import com.walmart.exception.RestServiceException;

public interface SentimentService {

    public double getSentimentResponse(String reviewText) throws RestServiceException;
    
}
