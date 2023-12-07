package use_case.LoggedIn.edit_profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditProfileInputDataTest {

    static String name = "John";
    static String password = "1234567";
    static double weight = 100.0;
    static double height = 180.0;

    static EditProfileInputData data;

    @BeforeAll
    static void setUp() {
        data = new EditProfileInputData(name, password, weight, height);
    }

    @Test
    void testGetMethod() {
        assertEquals(name, data.getName());
        assertEquals(password, data.getPassword());
        assertEquals(weight, data.getWeight());
        assertEquals(height, data.getHeight());
    }
}