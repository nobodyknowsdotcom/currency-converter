# feign-forex-service
---------------
# Usage:
```http://localhost:8100/currency-converter/from/RUB/to/USD/quantity/100```
---------------
> Supported currencies: RUB, USD, EUR;
> Supported quantity is BigDecimal;
---------------
# Project stack:
* Java 11, Spring Boot
* Feign (to interact with [forex-service](https://github.com/nobodyknowsdotcom/forex-service))
* Spring Web
* Lombok
--------------
## Note: for this application to work, you need to up [this application](https://github.com/nobodyknowsdotcom/forex-service) on the same machine.
