package config;

import org.example.config.GreetingConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = GreetingConfig.class)
public class PrimaryGreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testPrimaryGreetingService() {
        assertEquals("Hello", greetingService.greet());
    }
}
