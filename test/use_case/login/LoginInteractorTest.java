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

    private LoginInputData validInputData;
    private LoginInputData invalidInputData;
    private final String existingUsername = "user";
    private final String correctPassword = "correctPass";
    private final String wrongPassword = "wrongPass";
    private final double height = 178;
    private final double weight = 76;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        validInputData = new LoginInputData(existingUsername, correctPassword);
        invalidInputData = new LoginInputData(existingUsername, wrongPassword);
    }

    @Test
    void execute_UserDoesNotExist() {
        when(mockDataAccessObject.existsByName(existingUsername)).thenReturn(false);

        loginInteractor.execute(validInputData);

        verify(mockLoginPresenter).prepareFailView(existingUsername + ": Account does not exist.");
    }

    @Test
    void execute_IncorrectPassword() {
        when(mockDataAccessObject.existsByName(existingUsername)).thenReturn(true);
        when(mockDataAccessObject.get(existingUsername)).thenReturn(new User(existingUsername, correctPassword, height, weight));

        loginInteractor.execute(invalidInputData);

        verify(mockLoginPresenter).prepareFailView("Incorrect password for " + existingUsername + ".");
    }

    @Test
    void execute_SuccessfulLogin() {
        when(mockDataAccessObject.existsByName(existingUsername)).thenReturn(true);
        when(mockDataAccessObject.get(existingUsername)).thenReturn(new User(existingUsername, correctPassword, height, weight));

        loginInteractor.execute(validInputData);

        verify(mockLoginPresenter).prepareSuccessView(any(LoginOutputData.class));
    }
}
