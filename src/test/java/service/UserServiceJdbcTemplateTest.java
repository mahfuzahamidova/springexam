package service;

import org.example.SpringExamApplication;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = SpringExamApplication.class)
@ActiveProfiles("test")
public class UserServiceJdbcTemplateTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService.clearAllUsers();
        userService.addUser("John Doe", "john@example.com");
    }

    @Test
    public void testFindAllUsers() {
        var users = userService.findAllUsers();
        assertFalse(users.isEmpty(), "Список пользователей не должен быть пустым");
        assertEquals(1, users.size(), "Должен быть один пользователь в базе данных");
    }

    @Test
    public void testAddUser() {
        userService.addUser("Jane Doe", "jane@example.com");
        var users = userService.findAllUsers();
        assertEquals(2, users.size(), "Должно быть два пользователя в базе данных");
    }
}
