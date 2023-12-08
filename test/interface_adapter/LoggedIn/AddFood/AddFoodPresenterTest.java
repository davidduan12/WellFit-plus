package interface_adapter.LoggedIn.AddFood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.LoggedIn.add_food.AddFoodOutputData;

import static org.mockito.Mockito.*;

class AddFoodPresenterTest {

    @Mock
    private AddFoodViewModel addFoodViewModel;

    private AddFoodPresenter addFoodPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addFoodPresenter = new AddFoodPresenter(addFoodViewModel);

        // Mock the getState() method to return a non-null AddFoodState
        AddFoodState mockState = new AddFoodState();
        when(addFoodViewModel.getState()).thenReturn(mockState);
    }

    @Test
    void prepareSuccessView() {
        AddFoodOutputData foodData = new AddFoodOutputData("Apple");
        addFoodPresenter.prepareSuccessView(foodData);

        verify(addFoodViewModel).setState(any(AddFoodState.class));
        verify(addFoodViewModel).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        String errorMessage = "Error occurred";
        AddFoodState mockState = new AddFoodState();
        when(addFoodViewModel.getState()).thenReturn(mockState);

        addFoodPresenter.prepareFailView(errorMessage);

        verify(addFoodViewModel).getState();
        verify(addFoodViewModel).firePropertyChanged();
    }
}

