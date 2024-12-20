package config;

import org.example.config.ProfileConfig;
import org.example.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProfileConfig.class)
@ActiveProfiles("test")
public class ProfileTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testActiveProfile() {
        assertTrue(context.containsBean("testGreetingService"), "testGreetingService должен быть зарегистрирован");

        assertFalse(context.containsBean("devGreetingService"), "devGreetingService не должен быть зарегистрирован");
        assertFalse(context.containsBean("prodGreetingService"), "prodGreetingService не должен быть зарегистрирован");

        GreetingService greetingService = context.getBean("testGreetingService", GreetingService.class);
        assertEquals("Test Greeting", greetingService.greet());
    }
}
