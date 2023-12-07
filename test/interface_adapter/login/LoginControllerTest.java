package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.login.LoginInputBoundary;
import static org.mockito.Mockito.*;

class LoginControllerTest {

    @Mock
    private LoginInputBoundary loginInteractor;

    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        loginController = new LoginController(loginInteractor);
    }

    @Test
    void execute_CallsLoginInteractor() {
        String username = "testUser";
        String password = "testPassword";

        loginController.execute(username, password);

        verify(loginInteractor, times(1)).execute(any());
    }
}
