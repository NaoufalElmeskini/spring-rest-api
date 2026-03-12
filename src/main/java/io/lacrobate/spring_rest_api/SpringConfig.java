package io.lacrobate.spring_rest_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SpringConfig {
    @Bean
    public RestClient jsonPhClient() {
        return RestClient.create("https://jsonplaceholder.typicode.com");
    }
}
