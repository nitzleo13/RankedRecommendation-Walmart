package com.walmart.restclient.recommendation.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.constants.Common;
import com.walmart.exception.RestServiceException;
import com.walmart.restclient.recommendation.RecommendationService;
import com.walmart.restclient.recommendation.model.RecommendationResponse;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);


    @Autowired
    private RecommendationResponse recoResp;

    @PostConstruct
    public void init() {

    }
    
    public Integer[] getProductRecommendation(Integer firstProductId) throws RestServiceException {
        logger.info("Entered getProductRecommnendation() for calling recommendation API.");

        // validate input
        if (null == firstProductId) {
            logger.info("Input is invalid, Exception generated");
            logger.info("Exiting getProductDetails()");
            throw new RestServiceException(Common.INVALID_INPUT);
        }
        else {

            // get endpoint url
            String url = Common.RECOM_API_EP + firstProductId.intValue() + Common.API_KEY;
            logger.debug("The recommendation API's query url is constructed.", url);

            // invoke the api
            RestTemplate restTemplate = new RestTemplate();
            RecommendationResponse[] recomresp = null;
         try{   
            recomresp = restTemplate.getForObject(url, RecommendationResponse[].class);
        } catch (Exception e){
            logger.error("Exception occurred during invokation : " +e.getMessage());
            throw new RestServiceException(Common.API_GEN_EXCEPTION);
        }

            //get the first 10 recommendations
            return getRecommendations(recomresp);

        }

    }

    private Integer[] getRecommendations(RecommendationResponse[] recomresp) throws RestServiceException {
        logger.info("Entered getRecommendations()");

        if ((recomresp == null) || (recomresp.length == 0)) {
            logger.debug("Recommendation response is null or empty.Returning exception");
            logger.info("Exiting getRecommendations()");
            throw new RestServiceException(Common.NO_RECORDS_FOUND);
        }
        else {
            logger.debug("Total number of recommendation is : " + recomresp.length);
            
            //limit number of recommmendations to maximum of 10
            int numOfRecommendations = 10;
            if(recomresp.length <=10) {
                numOfRecommendations =recomresp.length; 
            }
            
            Integer[] recommendedId = new Integer[numOfRecommendations];
            for (int i = 0; i < numOfRecommendations; i++) {
                logger.debug("Recommendation Id : " + recomresp[i].getItemId());
                recommendedId[i] = recomresp[i].getItemId();
            }
            logger.info("Exit getRecommendations()");
            return recommendedId;

        }

    }

}
