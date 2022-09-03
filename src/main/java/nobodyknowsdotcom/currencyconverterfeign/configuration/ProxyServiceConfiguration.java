package nobodyknowsdotcom.currencyconverterfeign.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProxyServiceConfiguration {
    @Bean
    @LoadBalanced
    RestTemplate serviceInstanceListSupplier() {
        return new RestTemplate();
    }
}

