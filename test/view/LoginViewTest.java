package view;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        loginView = new LoginView(loginViewModel, null, viewManagerModel); // Passing null for LoginController
    }

    @Test
    void testUsernameInputFieldKeyTypeEvent() {
        KeyEvent keyEvent = new KeyEvent(loginView.usernameInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'a');
        loginView.usernameInputField.getKeyListeners()[0].keyTyped(keyEvent);

        assertEquals("a", loginViewModel.getState().getUsername());
    }


}
