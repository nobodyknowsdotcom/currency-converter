package nobodyknowsdotcom.currencyconverterfeign.util;

import org.springframework.stereotype.Component;

@Component
public class CurrencyUrlConverter {
    public String retrieveForexServiceUrl(String from, String to){
        return String.format("http://currency-exchange/from/%s/to/%s", from, to);
    }
}
