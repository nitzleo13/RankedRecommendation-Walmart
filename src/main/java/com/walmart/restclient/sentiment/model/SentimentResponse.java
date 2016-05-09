
package com.walmart.restclient.sentiment.model;

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
    "status",
    "usage",
    "totalTransactions",
    "language",
    "docSentiment"
})
public class SentimentResponse {

    @JsonProperty("status")
    private String status;
    @JsonProperty("usage")
    private String usage;
    @JsonProperty("totalTransactions")
    private String totalTransactions;
    @JsonProperty("language")
    private String language;
    @JsonProperty("docSentiment")
    private DocSentiment docSentiment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The usage
     */
    @JsonProperty("usage")
    public String getUsage() {
        return usage;
    }

    /**
     * 
     * @param usage
     *     The usage
     */
    @JsonProperty("usage")
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * 
     * @return
     *     The totalTransactions
     */
    @JsonProperty("totalTransactions")
    public String getTotalTransactions() {
        return totalTransactions;
    }

    /**
     * 
     * @param totalTransactions
     *     The totalTransactions
     */
    @JsonProperty("totalTransactions")
    public void setTotalTransactions(String totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    /**
     * 
     * @return
     *     The language
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The docSentiment
     */
    @JsonProperty("docSentiment")
    public DocSentiment getDocSentiment() {
        return docSentiment;
    }

    /**
     * 
     * @param docSentiment
     *     The docSentiment
     */
    @JsonProperty("docSentiment")
    public void setDocSentiment(DocSentiment docSentiment) {
        this.docSentiment = docSentiment;
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
