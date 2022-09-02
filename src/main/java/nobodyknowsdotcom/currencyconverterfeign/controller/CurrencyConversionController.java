package nobodyknowsdotcom.currencyconverterfeign.controller;

import lombok.extern.slf4j.Slf4j;
import nobodyknowsdotcom.currencyconverterfeign.dto.CurrencyConversionBean;
import nobodyknowsdotcom.currencyconverterfeign.util.CurrencyUrlConverter;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@RestController
public class CurrencyConversionController {
    private final WebClient.Builder loadBalancedWebClientBuilder;
    private final CurrencyUrlConverter converter;

    public CurrencyConversionController(WebClient.Builder webClientBuilder,
                                        CurrencyUrlConverter converter) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
        this.converter = converter;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = Objects.requireNonNull(loadBalancedWebClientBuilder.build().get()
                        .uri(converter.retrieveForexServiceUrl(from, to))
                        .retrieve().toEntity(CurrencyConversionBean.class).
                        block())
                        .getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}

