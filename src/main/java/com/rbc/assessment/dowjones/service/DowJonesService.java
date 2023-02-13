package com.rbc.assessment.dowjones.service;

import com.rbc.assessment.dowjones.models.StockPrice;

import java.util.List;

public interface DowJonesService {

    List<StockPrice> getStockPricesByTicker(String ticker);
    void addStockPrice(StockPrice stockPrice);
    void addBulkStockPrice(List<StockPrice> stockPrices);
}
