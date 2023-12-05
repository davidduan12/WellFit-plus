package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    String username = "Abb";
    String password = "123abcGG.";
    String sex = "Female";

    @BeforeEach
    void setUp() {
        user = new User(username, password, 20, 50.6, 178, sex);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void getUsername() {
        assertEquals("Abb", user.getUsername());

    }

    @Test
    void setUsername() {
        String newUsername = "newUsername";
        user.setUsername(newUsername);
        assertEquals(newUsername, user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    void setPassword() {
        String newPassword = "svagskvab**7dN";
        user.setPassword(newPassword);
        assertEquals(newPassword, user.getPassword());
    }

    @Test
    void getAge() {
        assertEquals(20, user.getAge());
    }

    @Test
    void setAge() {
        user.setAge(54);
        assertEquals(54, user.getAge());
    }

    @Test
    void getWeight() {
        assertEquals(50.6, user.getWeight());
    }

    @Test
    void setWeight() {
        user.setWeight(60.8);
        assertEquals(60.8, user.getWeight());
    }

    @Test
    void getHeight() {
        assertEquals(178, user.getHeight());
    }

    @Test
    void setHeight() {
        user.setHeight(179.9);
        assertEquals(179.9, user.getHeight());
    }

    @Test
    void getSex() {
        assertEquals(sex, user.getSex());
    }

    @Test
    void setSex() {
        String newSex = "Male";
        user.setSex();
        assertEquals(newSex,user.getSex());
    }

    @Test
    void getBMI() {
        assertEquals(0.0, user.getBMI());
    }

    @Test
    void setBMI() {
        double newBmi = 22.5;
        user.setBMI(newBmi);
        assertEquals(newBmi, user.getBMI());
    }
}