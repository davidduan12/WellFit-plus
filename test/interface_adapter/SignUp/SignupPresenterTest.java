package interface_adapter.SignUp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignupOutputData;

import static org.mockito.Mockito.*;

class SignupPresenterTest {

    @Mock
    private SignupViewModel mockSignupViewModel;
    @Mock
    private LoginViewModel mockLoginViewModel;
    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private LoginState mockLoginState;
    @Mock
    private SignupState mockSignupState;

    private SignupPresenter signupPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockLoginViewModel.getState()).thenReturn(mockLoginState);
        when(mockSignupViewModel.getState()).thenReturn(mockSignupState);
        signupPresenter = new SignupPresenter(mockViewManagerModel, mockSignupViewModel, mockLoginViewModel);
    }

    @Test
    void prepareSuccessView_UpdatesViewModelAndViewManager() {
        SignupOutputData outputData = new SignupOutputData("testUser", false);

        signupPresenter.prepareSuccessView(outputData);

        verify(mockLoginState, times(1)).setUsername("testUser");
        verify(mockLoginViewModel, times(1)).setState(mockLoginState);
        verify(mockLoginViewModel, times(1)).firePropertyChanged();
        verify(mockViewManagerModel, times(1)).setActiveView(mockLoginViewModel.getViewName());
        verify(mockViewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView_UpdatesViewModel() {
        String errorMessage = "Signup failed";

        signupPresenter.prepareFailView(errorMessage);

        verify(mockSignupState, times(1)).setUsernameError(errorMessage);
        verify(mockSignupState, times(1)).setPasswordError(errorMessage);
        verify(mockSignupState, times(1)).setRepeatPasswordError(errorMessage);
        verify(mockSignupViewModel, times(1)).firePropertyChanged();
    }
}
