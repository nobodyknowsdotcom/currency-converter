package nobodyknowsdotcom.currencyconverterfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyConverterFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterFeignApplication.class, args);
    }

}
