package interface_adapter.LoggedIn.AddExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddExerciseViewModelTest {
    private AddExerciseViewModel addExerciseViewModel;

    @BeforeEach
    public void setUp() {
        addExerciseViewModel = new AddExerciseViewModel();
    }

    @Test
    public void testDefaultValues() {
        assertEquals(AddExerciseState.class, addExerciseViewModel.getState().getClass());
    }

    @Test
    public void testSetState() {
        AddExerciseState newState = new AddExerciseState();
        addExerciseViewModel.setState(newState);
        assertEquals(newState, addExerciseViewModel.getState());
    }

    @Test
    public void testFirePropertyChanged() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        addExerciseViewModel.addPropertyChangeListener(listener);

        AddExerciseState newState = new AddExerciseState();
        addExerciseViewModel.firePropertyChanged();

        verify(listener, times(1)).propertyChange(any());

        addExerciseViewModel.setState(newState);
        addExerciseViewModel.firePropertyChanged();

        verify(listener, times(2)).propertyChange(any());
    }
}
