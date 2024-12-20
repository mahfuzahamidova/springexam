package config;

import org.example.config.PropertyConditionalConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PropertyConditionalConfig.class)
public class PropertyConditionalTest {

    @Autowired(required = false)
    private GreetingService featureEnabledService;

    @Test
    public void testPropertyCondition() {
        assertNotNull(featureEnabledService);
        assertEquals("Feature is enabled", featureEnabledService.greet());
    }
}
