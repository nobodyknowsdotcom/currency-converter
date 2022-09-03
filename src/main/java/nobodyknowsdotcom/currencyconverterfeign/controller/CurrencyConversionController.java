package nobodyknowsdotcom.currencyconverterfeign.controller;

import lombok.extern.slf4j.Slf4j;
import nobodyknowsdotcom.currencyconverterfeign.dto.CurrencyConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CurrencyConversionController {
    private final RestTemplate restTemplate;

    public CurrencyConversionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = restTemplate.getForEntity(
                String.format("http://forex-service/from/%s/to/%s", from, to),
                CurrencyConversionBean.class)
                .getBody();

        assert response != null;
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}

