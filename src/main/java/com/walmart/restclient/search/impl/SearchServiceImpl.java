package com.walmart.restclient.search.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.walmart.constants.Common;
import com.walmart.exception.RestServiceException;
import com.walmart.restclient.search.SearchService;
import com.walmart.restclient.search.model.Item;
import com.walmart.restclient.search.model.SearchResponse;

/**
 * 
 * @author KarthikNithya
 * 
 */
@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    private SearchResponse srchResp;

    @PostConstruct
    public void init() {

    }

   /**
    * 
    */
    public Integer getProductDetails(String searchTerm) throws RestServiceException {

        logger.info("Entering getProductDetails()");

        // validate input
        if ((null == searchTerm) || (searchTerm.isEmpty())) {
            logger.info("Input is invalid, Exception generated");
            logger.info("Exiting getProductDetails()");
            throw new RestServiceException(Common.INVALID_INPUT);
        }
        else {
            // get endpoint url
            String url = Common.SRCH_API_EP + searchTerm + Common.API_KEY;
            logger.debug("The search's query url is constructed.", url);

            // invoke the api
            RestTemplate restTemplate = new RestTemplate();
            try {
                srchResp = restTemplate.getForObject(url, SearchResponse.class);
            }
            catch (Exception e) {
                logger.error("Exception occurred during invokation : " + e.getMessage());
                throw new RestServiceException(Common.API_GEN_EXCEPTION);
            }

            // get the item id for first product returned in response
            logger.info("Return the ID of the first product matching the search string and exit the getProductDetails() method");
            logger.info("Exiting getProductDetails()");
            return getItemId(srchResp);
        }
    }

    /**
     * 
     * @param response
     * @return
     * @throws RestServiceException
     */
    private Integer getItemId(SearchResponse response) throws RestServiceException {

        logger.info("Entered getItemId()");

        if (response == null) {
            logger.debug("Search response object is null, REturning Gen Exception");
            logger.info("Exiting getItemId()");
            throw new RestServiceException(Common.API_GEN_EXCEPTION);

        }
        else {

            logger.debug("The number of items matching the query string is:" + response.getNumItems());

            List<Item> items = response.getItems();
            if ((null != items) && (items.size() > 0)) {
                Integer itemId = response.getItems().get(0).getItemId();
                logger.debug("Item id : " + itemId);
                logger.info("Exiting getItemId()");
                return itemId;
            }
            else {
                logger.debug("No items found.Returning no records found exception");
                logger.info("Exiting getItemId()");
                throw new RestServiceException(Common.NO_RECORDS_FOUND);
            }

        }
    }
}
