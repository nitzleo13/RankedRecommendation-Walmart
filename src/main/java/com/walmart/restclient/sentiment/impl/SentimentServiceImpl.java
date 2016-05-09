package com.walmart.restclient.sentiment.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.walmart.constants.Common;
import com.walmart.exception.RestServiceException;
import com.walmart.restclient.sentiment.SentimentService;
import com.walmart.restclient.sentiment.model.SentimentResponse;

public class SentimentServiceImpl implements SentimentService{

    @Autowired
    private SentimentResponse sentiResp;
    
    @PostConstruct
    public void init() {

    }
    
    private static final Logger logger = LoggerFactory.getLogger(SentimentServiceImpl.class);

    public double getSentimentResponse(String reviewText) throws RestServiceException {

        if ((null == reviewText) || (reviewText.isEmpty())) {
            logger.info("Input is invalid, Exception generated");
            logger.info("Exiting getSentimentResponse()");
            throw new RestServiceException(Common.INVALID_INPUT);
        }
        else {

            // get endpoint url
            String url = Common.ALCHEMY_API_URL + reviewText;
            logger.debug("The search's query url is constructed.", url);

            // invoke the api
            RestTemplate restTemplate = new RestTemplate();
            try {
                sentiResp = restTemplate.getForObject(url, SentimentResponse.class);
            }
            catch (Exception e) {
                logger.error("Exception occurred during invokation : " + e.getMessage());
                throw new RestServiceException(Common.API_GEN_EXCEPTION);
            }

            logger.info("Exiting getSentimentResponse()");
            return getScore(sentiResp);

        }

    }

    private double getScore(SentimentResponse response) throws RestServiceException {

        logger.info("Entered getScore()");
        if ((response == null) || (response.getDocSentiment() == null)) {
            logger.debug("Sentiment response object is null, Returning Gen Exception");
            logger.info("Exiting getScore()");
            throw new RestServiceException(Common.API_GEN_EXCEPTION);

        }
        else {

            logger.debug("Sentiment score is :  " + response.getDocSentiment().getScore());

            String sc = response.getDocSentiment().getScore();
            double score = 0;
            try {
                if ((null != sc) && !(sc.isEmpty())) {
                    score = Double.parseDouble(response.getDocSentiment().getScore());
                    logger.debug("Sentiment score is : " + score);
                }
            }
            catch (Exception e) {
                logger.error("Score computation has errors " + e.getMessage());
                return score;
            }
            return score;
        }
    }

}
