package interface_adapter.LoggedIn.AddFood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.beans.PropertyChangeListener;
import static org.mockito.Mockito.*;

class AddFoodViewModelTest {

    @Mock
    private PropertyChangeListener propertyChangeListener;

    private AddFoodViewModel addFoodViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addFoodViewModel = new AddFoodViewModel();
        addFoodViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    void testSetStateAndNotify() {
        AddFoodState newState = new AddFoodState();
        newState.setFood("Apple");
        newState.setFoodWeight(100);

        addFoodViewModel.setState(newState);

        verify(propertyChangeListener, times(1)).propertyChange(any());
    }
}
