--DROP TABLE IF EXISTS STOCKPRICE;
--
--CREATE TABLE STOCKPRICE (
--  	id INT AUTO_INCREMENT  PRIMARY KEY,
--  	quarter INTEGER NOT NULL,
--	stock VARCHAR(4) NOT NULL,
--	date DATE NOT NULL,
--	open NUMERIC,
--	high NUMERIC,
--	low NUMERIC,
--	close NUMERIC,
--	volume BIGINT,
--	percent_change_price NUMERIC,
--	percent_change_volume_over_last_wk NUMERIC,
--	previous_weeks_volume NUMERIC,
--	next_weeks_open NUMERIC,
--	next_weeks_close NUMERIC,
--	percent_change_next_weeks_price NUMERIC,
--	days_to_next_dividend INTEGER,
--	percent_return_next_dividend NUMERIC
--);