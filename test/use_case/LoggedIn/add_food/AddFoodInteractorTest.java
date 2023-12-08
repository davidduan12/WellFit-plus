package use_case.LoggedIn.add_food;

import interface_adapter.LoggedIn.LoggedInViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddFoodInteractorTest {

    @Mock
    private FoodAddDataAccessInterface mockFoodDataAccessObject;
    @Mock
    private AddFoodOutputBoundary mockAddFoodOutputBoundary;
    @Mock
    private LoggedInViewModel mockLoggedInViewModel;

    private AddFoodInteractor addFoodInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        addFoodInteractor = new AddFoodInteractor(mockAddFoodOutputBoundary, mockFoodDataAccessObject, mockLoggedInViewModel);
    }

    @Test
    void execute_Successful() {
        AddFoodInputData inputData = new AddFoodInputData("Apple", 100);
        when(mockFoodDataAccessObject.apiNutrient(anyString())).thenReturn(52.0); // Assuming successful calorie data retrieval
        addFoodInteractor.execute(inputData);
        verify(mockAddFoodOutputBoundary).prepareSuccessView(any(AddFoodOutputData.class));
    }

    @Test
    void execute_Failure() {
        AddFoodInputData inputData = new AddFoodInputData("InvalidFood", 100);
        when(mockFoodDataAccessObject.apiNutrient(anyString())).thenReturn(-1.0);

        addFoodInteractor.execute(inputData);

        verify(mockAddFoodOutputBoundary).prepareFailView("Invalid Input");
    }
}
