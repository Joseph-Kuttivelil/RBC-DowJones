### Description

This Application provides API's to add and view the stock prices of a particular stock.
Application has been built on Java 11 and Spring boot. 
Have used in memory database for storing data.
The inbuilt tomcat server is used for hosting the server.

### How to start the App

Use the command `java -jar dowjones-0.0.1-SNAPSHOT.jar com.rbc.assessment.dowjones.DowjonesApplication` to start the application
Have provided the jar file in the main folder itself.
Sample curl commands are at the bottom of the page

### API's

The Application has 3 API's

* `GET /dowjones/stockprice/{tickerName}` : This will get the stock price values for a particular ticker
* `POST /dowjones/stockprice` : This will add a stock price to the database
* `POST /dowjones/stockprices` :  This will add multiple (bulk) stock prices at once into the db

### Features that can be added

* More detailed unit tests
* Add additional and more descriptive comments
* Better error handling with a formatted error response
* Session and Security features
* API and DB validations
* Query params to filter the data better maybe with date or quarter
* Handle duplicate data

#### Sample curl commands

* ```
  curl --location --request GET 'http://localhost:8081/dowjones/stockprice/AA'
* ```
  curl --location --request POST 'http://localhost:8081/dowjones/stockprice' \
   --header 'Content-Type: application/json' \
   --data-raw '{
       "quarter": 1,
       "stock": "AA",
       "date": "01/21/2011",
       "open": 16.19,
       "high": 16.38,
       "low": 15.60,
       "close": 15.79,
       "volume": 138428495,
       "percent_change_price": -2.47066,
       "percent_change_volume_over_last_wk": -43.02495926,
       "previous_weeks_volume": 242963398,
       "next_weeks_open": 15.87,
       "next_weeks_close": 16.13,
       "percent_change_next_weeks_price": 1.63831,
       "days_to_next_dividend": 12,
       "percent_return_next_dividend": 0.189994
   }'
* ```
  curl --location --request POST 'http://localhost:8081/dowjones/stockprices/' \
     --header 'Content-Type: application/json' \
     --data-raw '[{
     
         "stock": "TTR",
         "date": "01/21/2011",
         "open": 16.19,
         "high": 16.38,
         "low": 15.60,
         "close": 15.79,
         "volume": 138428495,
         "percent_change_price": -2.47066,
         "percent_change_volume_over_last_wk": -43.02495926,
         "previous_weeks_volume": 242963398,
         "next_weeks_open": 15.87,
         "next_weeks_close": 16.13,
         "percent_change_next_weeks_price": 1.63831,
         "days_to_next_dividend": 12,
         "percent_return_next_dividend": 0.189994
     },
     {
         "quarter": 1,
         "stock": "TTR",
         "date": "01/21/2011",
         "open": 16.19,
         "high": 16.38,
         "low": 15.60,
         "close": 15.79,
         "volume": 138428495,
         "percent_change_price": -2.47066,
         "percent_change_volume_over_last_wk": -43.02495926,
         "previous_weeks_volume": 242963398,
         "next_weeks_open": 15.87,
         "next_weeks_close": 16.13,
         "percent_change_next_weeks_price": 1.63831,
         "days_to_next_dividend": 12,
         "percent_return_next_dividend": 0.189994
     }]' 

