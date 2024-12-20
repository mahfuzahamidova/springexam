package org.example.config;

import org.example.condition.JavaVersionCondition;
import org.example.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Conditional;

@Configuration
public class ConditionalConfig {

    @Bean
    @Conditional(JavaVersionCondition.class)
    public GreetingService java21GreetingService() {
        return () -> "Running on Java 21";
    }
}
