package com.rbc.assessment.dowjones.service;

import com.rbc.assessment.dowjones.exception.StockNotFoundException;
import com.rbc.assessment.dowjones.models.StockPrice;
import com.rbc.assessment.dowjones.repository.StockPriceRepository;
import com.rbc.assessment.dowjones.repository.entity.StockPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DowJonesServiceImpl implements DowJonesService{

    @Autowired
    private StockPriceRepository repository;

    public List<StockPrice> getStockPricesByTicker(String ticker) {
        List<StockPrice> stockPrices = entityToDTOMapper(repository.findByStock(ticker));
        if(stockPrices == null || stockPrices.size() < 1) {
            throw new StockNotFoundException(String.format("Failed to get stock price info for ticker %s ", ticker));
        }
        return stockPrices;

    }
    
    public void addStockPrice(StockPrice stockPrice) {
        StockPriceEntity entity = repository.save(dtoToEntityMapper(stockPrice));
        if(entity == null) {
            throw new RuntimeException(String.format("Failed to insert stock with ticker %s ", stockPrice.getStock()));
        }
    }

    @Transactional
    public void addBulkStockPrice(List<StockPrice> stockPrices) {
        List<StockPriceEntity> entityList = (List<StockPriceEntity>) repository.saveAll(dtoListToEntityListMapper(stockPrices));
        if (entityList == null || entityList.size() < 1) {
            throw new RuntimeException(String.format("Failed to bulk insert %s stocks", stockPrices.size()));
        }

    }

    private StockPriceEntity dtoToEntityMapper(StockPrice stockPriceDTO) {
        StockPriceEntity entity = new StockPriceEntity();
        entity.setQuarter(stockPriceDTO.getQuarter());
        entity.setStock(stockPriceDTO.getStock());
        entity.setDate(Date.valueOf(stockPriceDTO.getDate()));
        entity.setOpen(stockPriceDTO.getOpen());
        entity.setHigh(stockPriceDTO.getHigh());
        entity.setLow(stockPriceDTO.getLow());
        entity.setClose(stockPriceDTO.getClose());
        entity.setVolume(stockPriceDTO.getVolume());
        entity.setPercentChangePrice(stockPriceDTO.getPercentChangePrice());
        entity.setPercentChangeVolumeOverLastWk(stockPriceDTO.getPercentChangeVolumeOverLastWk());
        entity.setPreviousWeeksVolume(stockPriceDTO.getPreviousWeeksVolume());
        entity.setNextWeeksOpen(stockPriceDTO.getNextWeeksOpen());
        entity.setNextWeeksClose(stockPriceDTO.getNextWeeksClose());
        entity.setPercentChangeNextWeeksPrice(stockPriceDTO.getPercentChangeNextWeeksPrice());
        entity.setDaysToNextDividend(stockPriceDTO.getDaysToNextDividend());
        entity.setPercentReturnNextDividend(stockPriceDTO.getPercentReturnNextDividend());
        return entity;
    }

    private List<StockPrice> entityToDTOMapper(List<StockPriceEntity> entityList) {
        List<StockPrice> stockPricesDTO = new ArrayList<>();
        for(StockPriceEntity entity : entityList) {
            StockPrice stockPriceDTO = new StockPrice();
            stockPriceDTO.setId(entity.getId());
            stockPriceDTO.setQuarter(entity.getQuarter());
            stockPriceDTO.setStock(entity.getStock());
            stockPriceDTO.setDate(entity.getDate().toLocalDate());
            stockPriceDTO.setOpen(entity.getOpen());
            stockPriceDTO.setHigh(entity.getHigh());
            stockPriceDTO.setLow(entity.getLow());
            stockPriceDTO.setClose(entity.getClose());
            stockPriceDTO.setVolume(entity.getVolume());
            stockPriceDTO.setPercentChangePrice(entity.getPercentChangePrice());
            stockPriceDTO.setPercentChangeVolumeOverLastWk(entity.getPercentChangeVolumeOverLastWk());
            stockPriceDTO.setPreviousWeeksVolume(entity.getPreviousWeeksVolume());
            stockPriceDTO.setNextWeeksOpen(entity.getNextWeeksOpen());
            stockPriceDTO.setNextWeeksClose(entity.getNextWeeksClose());
            stockPriceDTO.setPercentChangeNextWeeksPrice(entity.getPercentChangeNextWeeksPrice());
            stockPriceDTO.setDaysToNextDividend(entity.getDaysToNextDividend());
            stockPriceDTO.setPercentReturnNextDividend(entity.getPercentReturnNextDividend());
            stockPricesDTO.add(stockPriceDTO);
        }

        return stockPricesDTO;
    }

    private List<StockPriceEntity> dtoListToEntityListMapper(List<StockPrice> stockPrices) {
        return stockPrices.stream()
                .map((dto) -> dtoToEntityMapper(dto))
                .collect(Collectors.toList());
    }
}
