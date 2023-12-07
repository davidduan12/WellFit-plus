package interface_adapter.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {

    @Test
    void testGettersAndSetters() {
        LoginState state = new LoginState();
        state.setUsername("user");
        state.setPassword("pass");
        state.setUsernameError("userError");
        state.setPasswordError("passError");

        assertAll("Testing all getters and setters",
                () -> assertEquals("user", state.getUsername()),
                () -> assertEquals("pass", state.getPassword()),
                () -> assertEquals("userError", state.getUsernameError()),
                () -> assertEquals("passError", state.getPasswordError())
        );
    }

    @Test
    void testCopyConstructor() {
        LoginState original = new LoginState();
        original.setUsername("user");
        original.setPassword("pass");
        original.setUsernameError("userError");
        original.setPasswordError("passError");

        LoginState copy = new LoginState(original);

        assertAll("Testing copy constructor",
                () -> assertEquals(original.getUsername(), copy.getUsername()),
                () -> assertEquals(original.getPassword(), copy.getPassword()),
                () -> assertEquals(original.getUsernameError(), copy.getUsernameError()),
                () -> assertEquals(original.getPasswordError(), copy.getPasswordError())
        );
    }
}
