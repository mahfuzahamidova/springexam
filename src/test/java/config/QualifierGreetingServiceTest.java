package config;

import org.example.config.GreetingConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = GreetingConfig.class)
public class QualifierGreetingServiceTest {

    @Autowired
    @Qualifier("spanishGreetingService")
    private GreetingService greetingService;

    @Test
    public void testQualifierGreetingService() {
        assertEquals("Hola", greetingService.greet());
    }
}
