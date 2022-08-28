package nobodyknowsdotcom.currencyconverterfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("nobodyknowsdotcom.currencyconverterfeign")
@EnableDiscoveryClient
public class CurrencyConverterFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterFeignApplication.class, args);
    }

}
