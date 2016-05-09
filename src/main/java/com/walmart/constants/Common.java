package com.walmart.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.input.RankerMain;

public final class Common {
	
	  private static final Logger logger = LoggerFactory.getLogger(RankerMain.class);

	private Common() {
        // restrict instantiation
	}
	
	public static final String API_KEY = "&apiKey=qrjatewj94vc24aqtnn6vfkg";
	
	public static final String SRCH_API_EP = "http://api.walmartlabs.com/v1/search?format=json&query=";

	public static final String RECOM_API_EP = "http://api.walmartlabs.com/v1/nbp?itemId=";

	public static final String REV_API_EP = "http://api.walmartlabs.com/v1/reviews/";

	public static final String ALCHEMY_API_API_KEY ="c7693b3f7d23503d307165d18b876c9014ee1df2";
	
	public static final String ALCHEMY_API_URL = "http://gateway-a.watsonplatform.net/calls/text/TextGetTextSentiment?apikey=c7693b3f7d23503d307165d18b876c9014ee1df2&outputMode=json&text=";
	
	
	public static final String NO_RECORDS_FOUND = "1001";
	public static final String API_GEN_EXCEPTION = "1002";
	public static final String NON_200 = "1003";

    public static final String INVALID_INPUT = "1004";


	

}
