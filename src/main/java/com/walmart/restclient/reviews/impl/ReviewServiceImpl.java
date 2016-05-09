package com.walmart.restclient.reviews.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.constants.Common;
import com.walmart.exception.RestServiceException;
import com.walmart.restclient.reviews.ReviewService;
import com.walmart.restclient.reviews.model.ReviewResponse;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Autowired
    private ReviewResponse revResp;

    @PostConstruct
    public void init() {

    }

    public ReviewResponse getProductReview(Integer ProductId) throws RestServiceException {

        // validate input
        if (null == ProductId) {
            logger.info("Input is invalid, Exception generated");
            logger.info("Exiting getProductDetails()");
            throw new RestServiceException(Common.INVALID_INPUT);

        }
        else {

            // set endpt url
            String url = Common.REV_API_EP + ProductId.intValue() + "?format=json" + Common.API_KEY;
            logger.debug("The review query url is constructed.", url);

            // invoke the api
            RestTemplate restTemplate = new RestTemplate();
            try{
                revResp = restTemplate.getForObject(url, ReviewResponse.class);
            } catch (Exception e){
                logger.error("Exception occurred during invokation : " +e.getMessage());
                throw new RestServiceException(Common.API_GEN_EXCEPTION);
            }
            
            
            // get the reviews for the prdt id
            logger.info("Return the reviews for each recommendation id");
            logger.info("Exiting getProductReview");
            
            return validateAndSendReview(revResp);

        }

    }

    private ReviewResponse validateAndSendReview(ReviewResponse response) throws RestServiceException {
        

        logger.info("Entered validateAndSendReview()");

        if (response == null) {
            logger.debug("Review response object is null, REturning Gen Exception");
            logger.info("Exiting validateAndSendReview()");
            throw new RestServiceException(Common.API_GEN_EXCEPTION);

        } else {
            logger.debug("Returning review response. " + response);
            logger.info("Exiting validateAndSendReview()");

          return response;          
        }

    }

}
