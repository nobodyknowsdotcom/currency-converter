# currency-converter
# Usage:
```http://localhost:8100/currency-converter/from/RUB/to/USD/quantity/100```
---------------
> Supported currencies: RUB, USD, EUR;
> Supported quantity is BigDecimal;
---------------
# Project stack:
* Java 11, Spring Boot
* Spring Cloud LoadBalancer
* Eureka Client
* Spring Web
--------------
## Note: you need to run at least one instance of the [forex-service](https://github.com/nobodyknowsdotcom/forex-service).
