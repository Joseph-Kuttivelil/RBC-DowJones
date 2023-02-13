package com.rbc.assessment.dowjones.controller;

import com.rbc.assessment.dowjones.models.StockPrice;
import com.rbc.assessment.dowjones.service.DowJonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DowJonesController {

    @Autowired
    private DowJonesService dowJonesService;

    /* API to get the Stock Price for a particular ticker*/
    @GetMapping("/dowjones/stockprice/{ticker}")
    public ResponseEntity<List<StockPrice>> getStockPricesByTicker(@PathVariable String ticker) {

        return ResponseEntity.ok(dowJonesService.getStockPricesByTicker(ticker));
    }

    /* API to add a Stock Price*/
    @PostMapping("/dowjones/stockprice")
    public ResponseEntity<String> addStockPrice(@RequestBody StockPrice stockPrice) {
        dowJonesService.addStockPrice(stockPrice);
        return ResponseEntity.ok("Success");
    }

    /* API to add Stock Prices in bulk*/
    @PostMapping("/dowjones/stockprices")
    public ResponseEntity<String> addBulkStockPrice(@RequestBody List<StockPrice> stockPrices) {
        dowJonesService.addBulkStockPrice(stockPrices);
        return ResponseEntity.ok("Success");
    }
}
