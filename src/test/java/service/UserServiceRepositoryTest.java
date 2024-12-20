package service;

import org.example.SpringExamApplication;
import org.example.entity.User;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SpringExamApplication.class)
@ActiveProfiles("test")
public class UserServiceRepositoryTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService.clearAllUsers();
        userService.addUser("John Doe", "john@example.com");
    }

    @Test
    public void testFindUserByEmail() {
        var user = userService.findUserByEmail("john@example.com");
        assertNotNull(user, "Пользователь должен быть найден по email");
        assertEquals("John Doe", user.getName(), "Имя пользователя должно быть 'John Doe'");
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane@example.com");
        user = userService.saveUser(user);

        assertNotNull(user.getId(), "Новый пользователь должен быть сохранён с ID");
        assertEquals("Jane Doe", user.getName(), "Имя нового пользователя должно быть 'Jane Doe'");
    }
}
