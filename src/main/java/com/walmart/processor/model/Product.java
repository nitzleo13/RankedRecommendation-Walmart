package com.walmart.processor.model;

import com.walmart.restclient.reviews.model.ReviewResponse;

public class Product implements Comparable<Product>{
    
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public ReviewResponse getReview() {
        return review;
    }
    public void setReview(ReviewResponse review) {
        this.review = review;
    }
    String itemId;
    Double rating;
    ReviewResponse review;
    @Override
    public int compareTo(Product o) {

        Double compareRating = o.getRating();
        
        if(compareRating > this.rating) {
            return 1;
        } else { 
            return 0;
        }        
        
    }

}



