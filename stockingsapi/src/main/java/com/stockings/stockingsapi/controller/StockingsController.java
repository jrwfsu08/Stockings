package com.stockings.stockingsapi.controller;

import com.stockings.stockingsapi.model.StockData;
import com.stockings.stockingsapi.service.RestfulClientForStockApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockingsController {

    @Autowired
    RestfulClientForStockApi restfulClientForStockApi;

    //TODO insert Request Mappings
    @RequestMapping(value = "/getmytickerinfo/{requestName}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<StockData> getStockInfo(@PathVariable String requestName) {

        StockData response = restfulClientForStockApi.getStockAPI();


        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
