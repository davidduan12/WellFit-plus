package interface_adapter.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {

    @Test
    void testGettersAndSetters() {
        LoginState state = new LoginState();
        state.setUsername("user");
        state.setPassword("pass");
        state.setError("userError");
        state.setError("passError");

        assertAll("Testing all getters and setters",
                () -> assertEquals("user", state.getUsername()),
                () -> assertEquals("pass", state.getPassword()),
                () -> assertEquals("userError", state.getError()),
                () -> assertEquals("passError", state.getError())
        );
    }

    @Test
    void testCopyConstructor() {
        LoginState original = new LoginState();
        original.setUsername("user");
        original.setPassword("pass");
        original.setError("userError");
        original.setError("passError");

        LoginState copy = new LoginState(original);

        assertAll("Testing copy constructor",
                () -> assertEquals(original.getUsername(), copy.getUsername()),
                () -> assertEquals(original.getPassword(), copy.getPassword()),
                () -> assertEquals(original.getError(), copy.getError()),
                () -> assertEquals(original.getError(), copy.getError())
        );
    }
}
