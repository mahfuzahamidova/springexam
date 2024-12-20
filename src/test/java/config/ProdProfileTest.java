package config;

import org.example.config.ProfileConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ProfileConfig.class)
@ActiveProfiles("prod")
public class ProdProfileTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testProdProfile() {
        assertTrue(context.containsBean("prodGreetingService"), "prodGreetingService должен быть зарегистрирован");

        assertFalse(context.containsBean("devGreetingService"), "devGreetingService не должен быть зарегистрирован");
        assertFalse(context.containsBean("testGreetingService"), "testGreetingService не должен быть зарегистрирован");

        GreetingService greetingService = context.getBean("prodGreetingService", GreetingService.class);
        assertEquals("Production Greeting", greetingService.greet());
    }
}
