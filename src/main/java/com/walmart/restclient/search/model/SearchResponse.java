
package com.walmart.restclient.search.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "query",
    "sort",
    "responseGroup",
    "totalResults",
    "start",
    "numItems",
    "items",
    "facets"
})
public class SearchResponse {

    @JsonProperty("query")
    private String query;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("responseGroup")
    private String responseGroup;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("numItems")
    private Integer numItems;
    @JsonProperty("items")
    @Valid
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("facets")
    @Valid
    private List<Object> facets = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The query
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The sort
     */
    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The responseGroup
     */
    @JsonProperty("responseGroup")
    public String getResponseGroup() {
        return responseGroup;
    }

    /**
     * 
     * @param responseGroup
     *     The responseGroup
     */
    @JsonProperty("responseGroup")
    public void setResponseGroup(String responseGroup) {
        this.responseGroup = responseGroup;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The start
     */
    @JsonProperty("start")
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    @JsonProperty("start")
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The numItems
     */
    @JsonProperty("numItems")
    public Integer getNumItems() {
        return numItems;
    }

    /**
     * 
     * @param numItems
     *     The numItems
     */
    @JsonProperty("numItems")
    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The facets
     */
    @JsonProperty("facets")
    public List<Object> getFacets() {
        return facets;
    }

    /**
     * 
     * @param facets
     *     The facets
     */
    @JsonProperty("facets")
    public void setFacets(List<Object> facets) {
        this.facets = facets;
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
