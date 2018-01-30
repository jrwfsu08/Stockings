package com.stockings.stockingsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockData {

    @JsonProperty("Meta Data")
    private Metadata metadata;

    @JsonProperty("Time Series (60min)")
    private TimeSeries timeSeries;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }
}
