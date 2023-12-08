package use_case.signup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupInputDataTest {

    private SignupInputData inputData;
    private final String expectedUsername = "testUser";
    private final String expectedPassword = "password123";
    private final String expectedRepeatPassword = "password123";
    private final double expectedWeight = 70.0;
    private final double expectedHeight = 175.0;

    @BeforeEach
    void setUp() {
        inputData = new SignupInputData(expectedUsername, expectedPassword, expectedRepeatPassword, expectedWeight, expectedHeight);
    }

    @Test
    void getUsername() {
        assertEquals(expectedUsername, inputData.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals(expectedPassword, inputData.getPassword());
    }

    @Test
    void getRepeatPassword() {
        assertEquals(expectedRepeatPassword, inputData.getRepeatPassword());
    }

    @Test
    void getWeight() {
        assertEquals(expectedWeight, inputData.getWeight());
    }

    @Test
    void getHeight() {
        assertEquals(expectedHeight, inputData.getHeight());
    }
}
