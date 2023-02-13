package com.rbc.assessment.dowjones.repository;

import com.rbc.assessment.dowjones.repository.entity.StockPriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPriceRepository  extends CrudRepository<StockPriceEntity, Long>  {
    List<StockPriceEntity> findByStock(String stock);
}
