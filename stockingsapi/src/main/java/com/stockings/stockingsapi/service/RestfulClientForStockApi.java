package com.stockings.stockingsapi.service;

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

    @PostConstruct
    public String getStockAPI(){

        String apiURL = "https://www.alphavantage.co/query";

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(apiURL)
                .queryParam("function","TIME_SERIES_INTRADAY")
                .queryParam("symbol","MSFT")
                .queryParam("interval","60min")
                .queryParam("outputsize", "compact")
                .queryParam("datatype","json")
                .queryParam("apikey","Z4DGG7FGNDV354HG");

        String response = restTemplate.getForObject(uriComponentsBuilder.toUriString(), String.class);

        System.out.println(response);
        return response;
    }

}
