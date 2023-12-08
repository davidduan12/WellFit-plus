package interface_adapter.SignUp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCreationFailedTest {

    @Test
    void exceptionMessageIsStoredCorrectly() {
        String errorMessage = "User creation failed.";
        UserCreationFailed exception = new UserCreationFailed(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}
