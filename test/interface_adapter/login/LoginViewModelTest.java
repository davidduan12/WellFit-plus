package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class LoginViewModelTest {

    private LoginViewModel loginViewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        loginViewModel = new LoginViewModel();
        mockListener = mock(PropertyChangeListener.class);
        loginViewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_UpdatesState() {
        LoginState newState = new LoginState();
        newState.setUsername("testUser");
        newState.setPassword("testPass");

        loginViewModel.setState(newState);

        assertEquals("testUser", loginViewModel.getState().getUsername());
        assertEquals("testPass", loginViewModel.getState().getPassword());
    }

    @Test
    void firePropertyChanged_FiresEvent() {
        LoginState newState = new LoginState();
        newState.setUsername("testUser");

        loginViewModel.setState(newState);
        loginViewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any());
    }
}
