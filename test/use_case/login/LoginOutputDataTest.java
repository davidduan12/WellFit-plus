package use_case.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginOutputDataTest {

    private LoginOutputData outputData;
    private final String expectedUsername = "testUser";
    private final boolean useCaseFailed = false;

    @BeforeEach
    void setUp() {
        outputData = new LoginOutputData(expectedUsername, useCaseFailed);
    }

    @AfterEach
    void tearDown() {
        outputData = null;
    }

    @Test
    void getUsername() {
        assertEquals(expectedUsername, outputData.getUsername());
    }

}
