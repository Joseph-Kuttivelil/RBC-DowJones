package com.rbc.assessment.dowjones.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Table(name = "STOCKPRICE")
@Entity
@Data
public class StockPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quarter", nullable = false)
    private Integer quarter;

    @Column(name = "stock", nullable = false)
    private String stock;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "open")
    private BigDecimal open;

    @Column(name = "high")
    private BigDecimal high;

    @Column(name = "low")
    private BigDecimal low;

    @Column(name = "close")
    private BigDecimal close;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "percent_change_price")
    private BigDecimal percentChangePrice;

    @Column(name = "percent_change_volume_over_last_wk")
    private BigDecimal percentChangeVolumeOverLastWk;

    @Column(name = "previous_weeks_volume")
    private BigDecimal previousWeeksVolume;

    @Column(name = "next_weeks_open")
    private BigDecimal nextWeeksOpen;

    @Column(name = "next_weeks_close")
    private BigDecimal nextWeeksClose;

    @Column(name = "percent_change_next_weeks_price")
    private BigDecimal percentChangeNextWeeksPrice;

    @Column(name = "days_to_next_dividend")
    private Integer daysToNextDividend;

    @Column(name = "percent_return_next_dividend")
    private BigDecimal percentReturnNextDividend;
}
