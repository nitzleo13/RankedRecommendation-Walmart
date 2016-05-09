
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
    "name",
    "overallRating",
    "reviewer",
    "reviewText",
    "submissionTime",
    "title",
    "upVotes",
    "downVotes",
    "productAttributes"
})
public class Review {

    @JsonProperty("name")
    private String name;
    @JsonProperty("overallRating")
    private OverallRating overallRating;
    @JsonProperty("reviewer")
    private String reviewer;
    @JsonProperty("reviewText")
    private String reviewText;
    @JsonProperty("submissionTime")
    private String submissionTime;
    @JsonProperty("title")
    private String title;
    @JsonProperty("upVotes")
    private String upVotes;
    @JsonProperty("downVotes")
    private String downVotes;
    @JsonProperty("productAttributes")
    private List<ProductAttribute> productAttributes = new ArrayList<ProductAttribute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The overallRating
     */
    @JsonProperty("overallRating")
    public OverallRating getOverallRating() {
        return overallRating;
    }

    /**
     * 
     * @param overallRating
     *     The overallRating
     */
    @JsonProperty("overallRating")
    public void setOverallRating(OverallRating overallRating) {
        this.overallRating = overallRating;
    }

    /**
     * 
     * @return
     *     The reviewer
     */
    @JsonProperty("reviewer")
    public String getReviewer() {
        return reviewer;
    }

    /**
     * 
     * @param reviewer
     *     The reviewer
     */
    @JsonProperty("reviewer")
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * 
     * @return
     *     The reviewText
     */
    @JsonProperty("reviewText")
    public String getReviewText() {
        return reviewText;
    }

    /**
     * 
     * @param reviewText
     *     The reviewText
     */
    @JsonProperty("reviewText")
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    /**
     * 
     * @return
     *     The submissionTime
     */
    @JsonProperty("submissionTime")
    public String getSubmissionTime() {
        return submissionTime;
    }

    /**
     * 
     * @param submissionTime
     *     The submissionTime
     */
    @JsonProperty("submissionTime")
    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The upVotes
     */
    @JsonProperty("upVotes")
    public String getUpVotes() {
        return upVotes;
    }

    /**
     * 
     * @param upVotes
     *     The upVotes
     */
    @JsonProperty("upVotes")
    public void setUpVotes(String upVotes) {
        this.upVotes = upVotes;
    }

    /**
     * 
     * @return
     *     The downVotes
     */
    @JsonProperty("downVotes")
    public String getDownVotes() {
        return downVotes;
    }

    /**
     * 
     * @param downVotes
     *     The downVotes
     */
    @JsonProperty("downVotes")
    public void setDownVotes(String downVotes) {
        this.downVotes = downVotes;
    }

    /**
     * 
     * @return
     *     The productAttributes
     */
    @JsonProperty("productAttributes")
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    /**
     * 
     * @param productAttributes
     *     The productAttributes
     */
    @JsonProperty("productAttributes")
    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
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
