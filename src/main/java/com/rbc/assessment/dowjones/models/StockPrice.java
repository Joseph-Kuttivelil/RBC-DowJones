package com.rbc.assessment.dowjones.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Validated
@Data
@Component
public class StockPrice   {
  @JsonProperty("id")
  private Long id;

  @NotNull(message = "quarter cannot be null")
  @JsonProperty("quarter")
  private Integer quarter;

  @NotNull(message = "stock cannot be null")
  @JsonProperty("stock")
  private String stock;

  @NotNull(message = "date cannot be null")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  @JsonProperty("date")
  private LocalDate date;

  @JsonProperty("open")
  private BigDecimal open;

  @JsonProperty("high")
  private BigDecimal high;

  @JsonProperty("low")
  private BigDecimal low;

  @JsonProperty("close")
  private BigDecimal close;

  @JsonProperty("volume")
  private Long volume;

  @JsonProperty("percent_change_price")
  private BigDecimal percentChangePrice;

  @JsonProperty("percent_change_volume_over_last_wk")
  private BigDecimal percentChangeVolumeOverLastWk;

  @JsonProperty("previous_weeks_volume")
  private BigDecimal previousWeeksVolume;

  @JsonProperty("next_weeks_open")
  private BigDecimal nextWeeksOpen;

  @JsonProperty("next_weeks_close")
  private BigDecimal nextWeeksClose;

  @JsonProperty("percent_change_next_weeks_price")
  private BigDecimal percentChangeNextWeeksPrice;

  @JsonProperty("days_to_next_dividend")
  private Integer daysToNextDividend;

  @JsonProperty("percent_return_next_dividend")
  private BigDecimal percentReturnNextDividend;
}
