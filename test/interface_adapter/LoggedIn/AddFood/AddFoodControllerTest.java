package interface_adapter.LoggedIn.AddFood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.LoggedIn.add_food.AddFoodInputBoundary;
import use_case.LoggedIn.add_food.AddFoodInputData;
import org.mockito.ArgumentMatcher;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

class AddFoodControllerTest {

    @Mock
    private AddFoodInputBoundary addFoodInputBoundary;

    private AddFoodController addFoodController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        addFoodController = new AddFoodController(addFoodInputBoundary);
    }

    @Test
    void execute() {
        String name = "Apple";
        float calorie = 52.0f;

        addFoodController.execute(name, calorie);

        verify(addFoodInputBoundary).execute(argThat(new ArgumentMatcher<AddFoodInputData>() {
            @Override
            public boolean matches(AddFoodInputData argument) {
                return argument.getName().equals(name) && argument.getWeight() == calorie;
            }
        }));

    }
}
