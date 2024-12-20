package config;

import org.example.config.ConditionalConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = ConditionalConfig.class)
public class JavaVersionConditionalTest {

    @Autowired(required = false)
    private GreetingService java21GreetingService;

    @Test
    public void testJavaVersionCondition() {
        if (System.getProperty("java.version").startsWith("21")) {
            assertNotNull(java21GreetingService);
            assertEquals("Running on Java 21", java21GreetingService.greet());
        } else {
            assertNull(java21GreetingService);
        }
    }
}
