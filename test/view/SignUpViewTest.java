package view;

import interface_adapter.SignUp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SignUpViewTest {

    private SignupController mockSignupController;
    private SignupViewModel mockSignupViewModel;
    private SignUpView signUpView;

    @BeforeEach
    void setUp() {
        mockSignupController = mock(SignupController.class);
        mockSignupViewModel = mock(SignupViewModel.class);
        signUpView = new SignUpView(mockSignupController, mockSignupViewModel);
    }

    @Test
    void signUpButtonActionPerformed() {
        // Simulate the sign-up button click
        ActionEvent signUpEvent = new ActionEvent(signUpView.signUp, ActionEvent.ACTION_PERFORMED, "sign up");
        signUpView.actionPerformed(signUpEvent);

    }

    @Test
    void cancelButtonActionPerformed() {
        ActionEvent cancelEvent = new ActionEvent(signUpView.cancel, ActionEvent.ACTION_PERFORMED, "cancel");
        signUpView.actionPerformed(cancelEvent);
    }

    // Additional tests for weightButton, heightButton, and key listeners
}
