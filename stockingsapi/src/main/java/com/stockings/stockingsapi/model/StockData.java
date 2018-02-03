package com.stockings.stockingsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class StockData {

    @JsonProperty("Meta Data")
    private Metadata metadata;

    @JsonProperty("Time Series (60min)")
    private Map<String, DetailTimeSeries> timeSeries;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Map<String, DetailTimeSeries> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(Map<String, DetailTimeSeries> timeSeries) {
        this.timeSeries = timeSeries;
    }
}
