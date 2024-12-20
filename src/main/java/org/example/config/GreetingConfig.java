package org.example.config;

import org.example.service.EnglishGreetingService;
import org.example.service.GreetingService;
import org.example.service.SpanishGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GreetingConfig {

    @Bean
    @Primary
    public GreetingService englishGreetingService() {
        return new EnglishGreetingService();
    }

    @Bean
    public GreetingService spanishGreetingService() {
        return new SpanishGreetingService();
    }
}
