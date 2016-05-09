
package com.walmart.restclient.recommendation.model;

import java.util.HashMap;
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
    "price",
    "sellerInfo",
    "standardShipRate",
    "availableOnline",
    "clearance"
})
public class BestMarketplacePrice {

    @JsonProperty("price")
    private Double price;
    @JsonProperty("sellerInfo")
    private String sellerInfo;
    @JsonProperty("standardShipRate")
    private Integer standardShipRate;
    @JsonProperty("availableOnline")
    private Boolean availableOnline;
    @JsonProperty("clearance")
    private Boolean clearance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The sellerInfo
     */
    @JsonProperty("sellerInfo")
    public String getSellerInfo() {
        return sellerInfo;
    }

    /**
     * 
     * @param sellerInfo
     *     The sellerInfo
     */
    @JsonProperty("sellerInfo")
    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    /**
     * 
     * @return
     *     The standardShipRate
     */
    @JsonProperty("standardShipRate")
    public Integer getStandardShipRate() {
        return standardShipRate;
    }

    /**
     * 
     * @param standardShipRate
     *     The standardShipRate
     */
    @JsonProperty("standardShipRate")
    public void setStandardShipRate(Integer standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    /**
     * 
     * @return
     *     The availableOnline
     */
    @JsonProperty("availableOnline")
    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    /**
     * 
     * @param availableOnline
     *     The availableOnline
     */
    @JsonProperty("availableOnline")
    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    /**
     * 
     * @return
     *     The clearance
     */
    @JsonProperty("clearance")
    public Boolean getClearance() {
        return clearance;
    }

    /**
     * 
     * @param clearance
     *     The clearance
     */
    @JsonProperty("clearance")
    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
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
