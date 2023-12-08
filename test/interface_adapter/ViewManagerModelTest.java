package interface_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class ViewManagerModelTest {

    private ViewManagerModel viewManagerModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        mockListener = mock(PropertyChangeListener.class);
        viewManagerModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void setActiveView_UpdatesViewName() {
        String newViewName = "testView";

        viewManagerModel.setActiveView(newViewName);

        assertEquals(newViewName, viewManagerModel.getActiveView());
    }

    @Test
    void firePropertyChanged_FiresEvent() {
        String newViewName = "testView";

        viewManagerModel.setActiveView(newViewName);
        viewManagerModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any());
    }
}
