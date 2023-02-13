package com.rbc.assessment.dowjones;

import com.rbc.assessment.dowjones.controller.DowJonesController;
import com.rbc.assessment.dowjones.exception.StockNotFoundException;
import com.rbc.assessment.dowjones.models.StockPrice;
import com.rbc.assessment.dowjones.service.DowJonesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DowJonesControllerTest {

	@Mock
	private DowJonesService dowJonesService;

	@InjectMocks
	private DowJonesController dowJonesController;

	@Test
	public void getStockPricesByTickerTest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		List<StockPrice> stockPrices = new ArrayList<>();
		StockPrice stockPrice = new StockPrice();
		stockPrice.setId(123L);
		stockPrice.setQuarter(1);
		stockPrice.setStock("AA");
		stockPrice.setDate(LocalDate.now());
		stockPrices.add(stockPrice);
		when(dowJonesService.getStockPricesByTicker(any())).thenReturn(stockPrices);

		ResponseEntity<List<StockPrice>> responseEntity = dowJonesController.getStockPricesByTicker("AA");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	public void getStockPricesByTickerNotFoundTest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(dowJonesService.getStockPricesByTicker(any())).thenThrow(new StockNotFoundException("Stock Not Found"));

		Assertions.assertThrows(StockNotFoundException.class, () -> {
			dowJonesController.getStockPricesByTicker("AA");
		});

	}

	@Test()
	public void addStockPriceTest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		ResponseEntity<String> responseEntity = dowJonesController.addStockPrice(new StockPrice());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	public void addBulkStockPricesTest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		ResponseEntity<String> responseEntity = dowJonesController.addBulkStockPrice(new ArrayList<StockPrice>());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}
}
