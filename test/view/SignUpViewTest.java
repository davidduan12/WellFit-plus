package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import interface_adapter.SignUp.SignupController;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.ViewManagerModel;

import static org.mockito.Mockito.*;

class SignUpViewTest {

    @Mock
    private SignupController mockSignupController;
    @Mock
    private SignupViewModel mockSignupViewModel;
    @Mock
    private ViewManagerModel mockViewManagerModel;

    private SignUpView signUpView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        signUpView = new SignUpView(mockSignupController, mockSignupViewModel, mockViewManagerModel);
    }

    @Test
    void signUpButtonActionPerformed() {

        signUpView.signUp.doClick();
    }
}
