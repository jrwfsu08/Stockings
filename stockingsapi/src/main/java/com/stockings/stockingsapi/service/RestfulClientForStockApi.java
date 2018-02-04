package com.stockings.stockingsapi.service;

import com.stockings.stockingsapi.model.StockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;


@Service
public class RestfulClientForStockApi {
    //TODO make a restful call to the stock API

    @Autowired
    RestTemplate restTemplate;

//    @PostConstruct
    public StockData getStockAPI(){

        String apiURL = "https://www.alphavantage.co/query";

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(apiURL)
                .queryParam("function","TIME_SERIES_INTRADAY")
                .queryParam("symbol","MSFT")
                .queryParam("interval","60min")
                .queryParam("outputsize", "compact")
                .queryParam("datatype","json")
                .queryParam("apikey","Z4DGG7FGNDV354HG");

        StockData response = restTemplate.getForObject(uriComponentsBuilder.toUriString(), StockData.class);

        System.out.println(response.getMetadata().getOutputSize());
        System.out.println(response.getTimeSeries());
        return response;
    }

}
