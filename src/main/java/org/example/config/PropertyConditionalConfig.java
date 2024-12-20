package org.example.config;

import org.example.service.GreetingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConditionalConfig {

    @Bean
    @ConditionalOnProperty(name = "app.feature.enabled", havingValue = "true")
    public GreetingService featureEnabledService() {
        return () -> "Feature is enabled";
    }
}
