package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private UserFactoryInterface userFactory;

    @BeforeEach
    void setUp() {
        userFactory = new UserFactory();
    }


    @Test
    void create() {
        String username = "Amy";
        String password = "123abc.";
        String sex = "male";

        User newUser = userFactory.create(username, password, 20, 50.6);

        assertNotNull(newUser);
        assertEquals(username, newUser.getUsername());
        assertEquals(password, newUser.getPassword());


    }
}