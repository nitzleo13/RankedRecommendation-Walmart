package com.walmart.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.walmart.constants.Common;
import com.walmart.exception.RestServiceException;
import com.walmart.processor.model.Product;
import com.walmart.restclient.recommendation.RecommendationService;
import com.walmart.restclient.recommendation.impl.RecommendationServiceImpl;
import com.walmart.restclient.reviews.ReviewService;
import com.walmart.restclient.reviews.impl.ReviewServiceImpl;
import com.walmart.restclient.reviews.model.Review;
import com.walmart.restclient.reviews.model.ReviewResponse;
import com.walmart.restclient.search.SearchService;
import com.walmart.restclient.search.impl.SearchServiceImpl;
import com.walmart.restclient.sentiment.SentimentService;
import com.walmart.restclient.sentiment.impl.SentimentServiceImpl;


public class WalmartRankingProcessor {

    private static final Logger logger = LoggerFactory.getLogger(WalmartRankingProcessor.class);


    public String process(String productName) {

        logger.info("Enter process()");
        String response = null;

        try {

            // Step1 : Consume search api and retrieve first productId
            SearchService schSvc = new SearchServiceImpl();
            Integer firstProductId = schSvc.getProductDetails(productName);
            logger.debug("The product id corresponding to " + productName + " is: " + firstProductId);

            // Step 2 : Consume recommendation api and retrieve first 10 recomendations
            RecommendationService recoSvc = new RecommendationServiceImpl();
            Integer[] recommendedTenId = recoSvc.getProductRecommendation(firstProductId);
            logger.debug("The recommended products for product ID : " + "" + firstProductId + " are : "
                    + recommendedTenId.toString());

            // Step 3 : Retrieve reviews for each of the product id
            ReviewService rviewSvc = new ReviewServiceImpl();
            Map<Integer, ReviewResponse> mapReviews = new HashMap<Integer, ReviewResponse>();
            for (int i = 0; i < recommendedTenId.length; i++) {
                try {
                    ReviewResponse reviewResp = rviewSvc.getProductReview(recommendedTenId[i]);
                    mapReviews.put(recommendedTenId[i], reviewResp);
                }
                catch (RestServiceException e) {
                    logger.error("Exception occurred : " + e.getMessage());
                    continue;
                }

            }
            
            //Step 4 sentiment analysis and ranking
            
            // log reviews
            logreviews(mapReviews, recommendedTenId);
            //gather review scores
            List list = rankReviews(mapReviews, recommendedTenId);
            

            // Step 5 rank order by rating
            Collections.sort(list);
           
                    
            // Step 6 return product details for console output
            StringBuffer sb = new StringBuffer();
            sb.append("Rank order for recommendations, based on review sentiments is : " + list.size());
            sb.append(System.getProperty("line.separator"));
            for (int i = 0; i < list.size(); i++) {
                Product pr = (Product) list.get(i);
                sb.append("Rank #  " + (i+1));
                sb.append(System.getProperty("line.separator"));
                sb.append("Product Name :  " + pr.getReview().getName());
                sb.append(System.getProperty("line.separator"));
                sb.append("Product Id : " + pr.getReview().getItemId());
                sb.append(System.getProperty("line.separator"));
                sb.append("Score : " + pr.getRating());
                sb.append(System.getProperty("line.separator"));
            }
            
            
            response = sb.toString();
            

        }
        catch (RestServiceException restSvcEx) {
            logger.error("Exception occurred : " + restSvcEx.getMessage());
            response = processResp(restSvcEx.getMessage());
        }

        return response;
    }

    private List rankReviews(Map<Integer, ReviewResponse> mapReviews, Integer[] recommendedTenId) throws RestServiceException {
        
        List<Product> lst = new ArrayList<Product>();
        
        logger.debug("recommendedTenId : " + recommendedTenId.length);
        
        for (int i = 0; i < recommendedTenId.length; i++) {
            ReviewResponse resp = mapReviews.get(recommendedTenId[i]);
            if ((null != resp) && (null != resp.getReviews()) && (resp.getReviews().size() > 0)) {

                List<Review> lstReview = resp.getReviews();
                Product pr = new Product();
                pr.setReview(resp);
                logger.info("Reviews for product : " + resp.getName() + " and Item ID : " + resp.getItemId());
                double total=0;
                for (int j = 0; j < lstReview.size(); j++) {
                    
                    String reviewtxt = lstReview.get(j).getReviewText();
                    logger.info("#" + (j + 1) + " : " + lstReview.get(j).getReviewText());
                    logger.info("*********************************************************");
                    SentimentService sentSvc = new SentimentServiceImpl();
                    try {
                        total=total + sentSvc.getSentimentResponse(reviewtxt);
                    }
                    catch (Exception e) {
                       logger.error("Exception occurred : " + e.getMessage());
                       throw new RestServiceException(Common.API_GEN_EXCEPTION);
                    }
               
                }
                pr.setRating(total);
                lst.add(pr);
            }

        }
        
        return lst;

    }

    /**
     * 
     * @param mapReviews
     * @param recommendedTenId
     */
    private void logreviews(Map<Integer, ReviewResponse> mapReviews, Integer[] recommendedTenId) {

        for (int i = 0; i < recommendedTenId.length; i++) {

            ReviewResponse resp = mapReviews.get(recommendedTenId[i]);
            if ((null != resp) && (null != resp.getReviews()) && (resp.getReviews().size() > 0)) {

                List<Review> lstReview = resp.getReviews();

                logger.info("Reviews for product : " + resp.getName() + " and Item ID : " + resp.getItemId());
                for (int j = 0; j < lstReview.size(); j++) {
                    logger.info("#" + (j + 1) + " : " + lstReview.get(j).getReviewText());
                    logger.info("*********************************************************");
                }
            }

        }

    }

    /**
     * 
     * @param message
     * @return
     */
    private String processResp(String message) {

        if (Common.API_GEN_EXCEPTION.equalsIgnoreCase(message)) {
            return "Ran into a snag processing your request. Run the search again";

        }
        else if (Common.NO_RECORDS_FOUND.equals(message)) {
            return "No matching records found. Please try again";
        }
        else if (Common.INVALID_INPUT.equalsIgnoreCase(message)) {
            return "Input is invalid. Please try again with a valid input";
        }
        else {
            return "Ran into a snag processing your request. Run the search again";
        }

    }

}
