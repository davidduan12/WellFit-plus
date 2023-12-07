package interface_adapter.SignUp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class SignupControllerTest {

    @Mock
    private SignupInputBoundary mockSignupInputBoundary;

    private SignupController signupController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        signupController = new SignupController(mockSignupInputBoundary);
    }

    @Test
    void execute_CallsSignupInteractorWithCorrectData() {
        String username = "testUser";
        String password1 = "pass123";
        String password2 = "pass123";
        double weight = 70.0;
        double height = 175.0;

        signupController.execute(username, password1, password2, weight, height);

        verify(mockSignupInputBoundary, times(1)).execute(any(SignupInputData.class));
    }
}
