package view;

import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class SignUpViewTest {

    private SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;
    private SignUpView signUpView;

    @BeforeEach
    void setUp() {
        signupViewModel = new SignupViewModel();
        viewManagerModel = new ViewManagerModel();
        signUpView = new SignUpView(null, signupViewModel, viewManagerModel); // Controller is not used in the test
    }

    @Test
    void testUsernameInputFieldKeyTypeEvent() {
        KeyEvent keyEvent = new KeyEvent(signUpView.usernameInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'a');
        signUpView.usernameInputField.getKeyListeners()[0].keyTyped(keyEvent);
        assertEquals("a", signupViewModel.getState().getUsername());
    }


    @Test
    void testWeightInputFieldKeyTypeEvent() {
        signUpView.weightInputField.setText("5"); // Setting initial text
        KeyEvent keyEvent = new KeyEvent(signUpView.weightInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, '0');
        signUpView.weightInputField.getKeyListeners()[0].keyTyped(keyEvent);
        assertEquals(50, signupViewModel.getState().getWeight());
    }

    // Example for heightInputField
    @Test
    void testHeightInputFieldKeyTypeEvent() {
        signUpView.heightInputField.setText("17"); // Setting initial text
        KeyEvent keyEvent = new KeyEvent(signUpView.heightInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, '5');
        signUpView.heightInputField.getKeyListeners()[0].keyTyped(keyEvent);
        assertEquals(175, signupViewModel.getState().getHeight());
    }
}
