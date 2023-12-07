package use_case.login;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class LoginInteractorTest {

    @Mock
    private LoginDataAccessInterface mockDataAccessObject;
    @Mock
    private LoginOutputBoundary mockLoginPresenter;

    @InjectMocks
    private LoginInteractor loginInteractor;

    private final String username = "testUser";
    private final String password = "password123";
    private final String wrongPassword = "wrongPassword";
    private final double height = 189;
    private final double weight = 78;
    private LoginInputData validLoginData;
    private LoginInputData invalidLoginData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        validLoginData = new LoginInputData(username, password);
        invalidLoginData = new LoginInputData(username, wrongPassword);
    }

    @Test
    void execute_UserDoesNotExist() {
        when(mockDataAccessObject.existsByName(username)).thenReturn(false);

        loginInteractor.execute(validLoginData);

        verify(mockLoginPresenter).prepareFailView(username + ": Account does not exist.");
    }

    @Test
    void execute_IncorrectPassword() {
        when(mockDataAccessObject.existsByName(username)).thenReturn(true);
        when(mockDataAccessObject.get(username)).thenReturn(new User(username, password, height,weight));

        loginInteractor.execute(invalidLoginData);

        verify(mockLoginPresenter).prepareFailView("Incorrect password for " + username + ".");
    }

    @Test
    void execute_SuccessfulLogin() {
        when(mockDataAccessObject.existsByName(username)).thenReturn(true);
        when(mockDataAccessObject.get(username)).thenReturn(new User(username, password, height, weight));

        loginInteractor.execute(validLoginData);

        verify(mockDataAccessObject, times(1)).get(username);
        verify(mockLoginPresenter).prepareSuccessView(any(LoginOutputData.class));
    }

}
