package az.hakaton.karbon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://10.249.160.115:8083") // Base URL for all endpoints
                .defaultHeader("accept", "*/*")        // Default headers
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}

