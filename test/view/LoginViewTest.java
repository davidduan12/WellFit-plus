package view;

import interface_adapter.login.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private LoginViewModel mockLoginViewModel;
    private LoginController mockLoginController;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        mockLoginViewModel = mock(LoginViewModel.class);
        mockLoginController = mock(LoginController.class);
        loginView = new LoginView(mockLoginViewModel, mockLoginController);
    }

    @Test
    void propertyChange_UpdatesUsernameLabel() {
        // Given
        LoginState mockState = new LoginState();
        mockState.setUsername("testUser");
        PropertyChangeEvent evt = new PropertyChangeEvent(this, "username", null, mockState);

        // When
        loginView.propertyChange(evt);

        // Then
        assertEquals("testUser", loginView.username.getText(), "Username label should update with new username.");
    }

    @Test
    void actionPerformed_PrintsActionCommand() {
        // Given
        ActionEvent mockEvent = new ActionEvent(loginView.logOut, ActionEvent.ACTION_PERFORMED, "logout");

        // Capture System.out output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        loginView.actionPerformed(mockEvent);

        // Then
        assertTrue(outContent.toString().contains("Click logout"), "Should print the action command to console.");

        // Reset System.out
        System.setOut(System.out);
    }

    // Additional tests as needed
}
