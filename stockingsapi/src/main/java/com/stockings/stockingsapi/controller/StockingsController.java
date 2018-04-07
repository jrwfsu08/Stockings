package com.stockings.stockingsapi.controller;

import com.stockings.stockingsapi.model.StockData;
import com.stockings.stockingsapi.service.RestfulClientForStockApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockingsController {

//    @Autowired
    private RestfulClientForStockApi RestfulClientForStockApiImpl;

    @Autowired
    StockingsController(RestfulClientForStockApi restfulClientForStockApi){
        this.RestfulClientForStockApiImpl = restfulClientForStockApi;
    }


//    //TODO insert Request Mappings
    @RequestMapping("/index")
    public StockData getStockInfo(){
       return RestfulClientForStockApiImpl.getStockAPI();
    }

}
