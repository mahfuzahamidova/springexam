package org.example.config;

import org.example.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public GreetingService devGreetingService() {
        return () -> "Development Greeting";
    }

    @Bean
    @Profile("prod")
    public GreetingService prodGreetingService() {
        return () -> "Production Greeting";
    }

    @Bean
    @Profile("test")
    public GreetingService testGreetingService() {
        return () -> "Test Greeting";
    }
}
