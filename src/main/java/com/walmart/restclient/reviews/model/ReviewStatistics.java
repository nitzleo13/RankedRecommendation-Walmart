
package com.walmart.restclient.reviews.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "averageOverallRating",
    "overallRatingRange",
    "ratingDistributions",
    "totalReviewCount"
})
public class ReviewStatistics {

    @JsonProperty("averageOverallRating")
    private String averageOverallRating;
    @JsonProperty("overallRatingRange")
    private String overallRatingRange;
    @JsonProperty("ratingDistributions")
    private List<RatingDistribution> ratingDistributions = new ArrayList<RatingDistribution>();
    @JsonProperty("totalReviewCount")
    private String totalReviewCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The averageOverallRating
     */
    @JsonProperty("averageOverallRating")
    public String getAverageOverallRating() {
        return averageOverallRating;
    }

    /**
     * 
     * @param averageOverallRating
     *     The averageOverallRating
     */
    @JsonProperty("averageOverallRating")
    public void setAverageOverallRating(String averageOverallRating) {
        this.averageOverallRating = averageOverallRating;
    }

    /**
     * 
     * @return
     *     The overallRatingRange
     */
    @JsonProperty("overallRatingRange")
    public String getOverallRatingRange() {
        return overallRatingRange;
    }

    /**
     * 
     * @param overallRatingRange
     *     The overallRatingRange
     */
    @JsonProperty("overallRatingRange")
    public void setOverallRatingRange(String overallRatingRange) {
        this.overallRatingRange = overallRatingRange;
    }

    /**
     * 
     * @return
     *     The ratingDistributions
     */
    @JsonProperty("ratingDistributions")
    public List<RatingDistribution> getRatingDistributions() {
        return ratingDistributions;
    }

    /**
     * 
     * @param ratingDistributions
     *     The ratingDistributions
     */
    @JsonProperty("ratingDistributions")
    public void setRatingDistributions(List<RatingDistribution> ratingDistributions) {
        this.ratingDistributions = ratingDistributions;
    }

    /**
     * 
     * @return
     *     The totalReviewCount
     */
    @JsonProperty("totalReviewCount")
    public String getTotalReviewCount() {
        return totalReviewCount;
    }

    /**
     * 
     * @param totalReviewCount
     *     The totalReviewCount
     */
    @JsonProperty("totalReviewCount")
    public void setTotalReviewCount(String totalReviewCount) {
        this.totalReviewCount = totalReviewCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
