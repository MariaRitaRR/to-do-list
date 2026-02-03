package tech.ada.java.todolistapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    /*
    registra um WebClient bean com base no url
    para dummyjson.com
    */


    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
    }
}
