package use_case.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginInputDataTest {

    @Test
    void getUsername() {
        String expectedUsername = "testUser";
        LoginInputData loginInputData = new LoginInputData(expectedUsername, "testPassword");
        String actualUsername = loginInputData.getUsername();
        assertEquals(expectedUsername, actualUsername);
    }

    @Test
    void getPassword() {
        String expectedPassword = "testPassword";
        LoginInputData loginInputData = new LoginInputData("testUser", expectedPassword);
        String actualPassword = loginInputData.getPassword();
        assertEquals(expectedPassword, actualPassword);
    }
}
