package interface_adapter.SignUp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

class SignupViewModelTest {

    private SignupViewModel signupViewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        signupViewModel = new SignupViewModel();
        mockListener = mock(PropertyChangeListener.class);
        signupViewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setState_UpdatesState() {
        SignupState newState = new SignupState();
        newState.setUsername("testUser");
        newState.setPassword("testPass");
        newState.setRepeatPassword("testRepeatPass");

        signupViewModel.setState(newState);

        assertAll("Testing all getters after setting state",
                () -> assertEquals("testUser", signupViewModel.getState().getUsername()),
                () -> assertEquals("testPass", signupViewModel.getState().getPassword()),
                () -> assertEquals("testRepeatPass", signupViewModel.getState().getRepeatPassword())
        );
    }

    @Test
    void firePropertyChanged_FiresEvent() {
        SignupState newState = new SignupState();
        newState.setUsername("testUser");

        signupViewModel.setState(newState);
        signupViewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any());
    }
}
