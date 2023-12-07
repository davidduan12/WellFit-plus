package interface_adapter.SignUp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupStateTest {

    @Test
    void testGettersAndSetters() {
        SignupState state = new SignupState();
        state.setUsername("user");
        state.setPassword("pass");
        state.setRepeatPassword("repeatPass");
        state.setHeight(180);
        state.setWeight(75);
        state.setUsernameError("userError");
        state.setPasswordError("passError");
        state.setRepeatPasswordError("repeatPassError");
        state.setHeightError(0.5);
        state.setWeightError(0.2);

        assertAll("Testing all getters and setters",
                () -> assertEquals("user", state.getUsername()),
                () -> assertEquals("pass", state.getPassword()),
                () -> assertEquals("repeatPass", state.getRepeatPassword()),
                () -> assertEquals(180, state.getHeight()),
                () -> assertEquals(75, state.getWeight()),
                () -> assertEquals("userError", state.getUsernameError()),
                () -> assertEquals("passError", state.getPasswordError()),
                () -> assertEquals("repeatPassError", state.getRepeatPasswordError()),
                () -> assertEquals(0.5, state.getHeightError()),
                () -> assertEquals(0.2, state.getWeightError())
        );
    }

    @Test
    void testCopyConstructor() {
        SignupState original = new SignupState();
        original.setUsername("user");
        original.setPassword("pass");
        original.setRepeatPassword("repeatPass");
        original.setHeight(180);
        original.setWeight(75);

        SignupState copy = new SignupState(original);

        assertAll("Testing copy constructor",
                () -> assertEquals(original.getUsername(), copy.getUsername()),
                () -> assertEquals(original.getPassword(), copy.getPassword()),
                () -> assertEquals(original.getRepeatPassword(), copy.getRepeatPassword()),
                () -> assertEquals(original.getHeight(), copy.getHeight()),
                () -> assertEquals(original.getWeight(), copy.getWeight())
        );
    }

    @Test
    void testToString() {
        SignupState state = new SignupState();
        state.setUsername("user");
        state.setPassword("pass");
        state.setRepeatPassword("repeatPass");

        String expectedString = "SignupState{username='user', password='pass', repeatPassword='repeatPass'}";
        assertEquals(expectedString, state.toString());
    }
}
