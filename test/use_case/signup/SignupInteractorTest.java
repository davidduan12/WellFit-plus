package use_case.signup;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class SignupInteractorTest {

    @Mock
    private SignupDataAccessInterface mockDataAccessObject;
    @Mock
    private SignupOutputBoundary mockUserPresenter;
    @Mock
    private UserFactory mockUserFactory;

    @InjectMocks
    private SignupInteractor signupInteractor;

    private final String username = "testUser";
    private final String password = "password123";
    private final String repeatPassword = "password123";
    private final double weight = 70.0;
    private final double height = 175.0;
    private SignupInputData inputData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        inputData = new SignupInputData(username, password, repeatPassword, weight, height);
    }

    @Test
    void execute_UserAlreadyExists() {
        when(mockDataAccessObject.existsByName(username)).thenReturn(true);
        signupInteractor.execute(inputData);
        verify(mockUserPresenter).prepareFailView("User already exists.");
    }

    @Test
    void execute_PasswordsDoNotMatch() {
        SignupInputData inputDataMismatch = new SignupInputData(username, password, "wrongPassword", weight, height);
        signupInteractor.execute(inputDataMismatch);
        verify(mockUserPresenter).prepareFailView("Passwords don't match.");
    }

    @Test
    void execute_SuccessfulSignup() {
        when(mockDataAccessObject.existsByName(username)).thenReturn(false);
        User mockUser = mock(User.class);
        when(mockUserFactory.create(anyString(), anyString(), anyDouble(), anyDouble())).thenReturn(mockUser);
        when(mockUser.getUsername()).thenReturn(username);

        // Act
        signupInteractor.execute(inputData);

        // Assert
        verify(mockDataAccessObject).save(mockUser);
        verify(mockUserPresenter).prepareSuccessView(any(SignupOutputData.class));
    }

    // More tests can be added for different scenarios
}
