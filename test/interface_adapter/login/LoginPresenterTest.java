package interface_adapter.login;


import interface_adapter.LoggedIn.LoggedInState;
import interface_adapter.LoggedIn.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.login.LoginOutputData;

import static org.mockito.Mockito.*;

class LoginPresenterTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private LoggedInViewModel mockLoggedInViewModel;
    @Mock
    private LoginViewModel mockLoginViewModel;
    @Mock
    private LoggedInState mockLoggedInState;
    @Mock
    private LoginState mockLoginState;

    private LoginPresenter loginPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockLoggedInViewModel.getState()).thenReturn(mockLoggedInState);
        when(mockLoginViewModel.getState()).thenReturn(mockLoginState);
        loginPresenter = new LoginPresenter(mockViewManagerModel, mockLoggedInViewModel, mockLoginViewModel);
    }


    @Test
    void prepareSuccessView() {
        LoginOutputData outputData = new LoginOutputData("testUser", false);

        loginPresenter.prepareSuccessView(outputData);

        verify(mockLoggedInState, times(1)).setUsername("testUser");
        verify(mockLoggedInViewModel, times(1)).setState(mockLoggedInState);
        verify(mockLoggedInViewModel, times(1)).firePropertyChanged();
        verify(mockViewManagerModel, times(1)).setActiveView(mockLoggedInViewModel.getViewName());
        verify(mockViewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        String errorMessage = "Invalid credentials";

        loginPresenter.prepareFailView(errorMessage);

        verify(mockLoginState, times(1)).setError(errorMessage);
        verify(mockLoginViewModel, times(1)).setState(mockLoginState);
        verify(mockLoginViewModel, times(1)).firePropertyChanged();
    }
}
