package use_case.LoggedIn.add_food;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddFoodInputDataTest {

    private AddFoodInputData foodInputData;
    private final String expectedFoodName = "Banana";
    private final double expectedWeight = 120.0;

    @BeforeEach
    void setUp() {
        // Initialize the AddFoodInputData object before each test
        foodInputData = new AddFoodInputData(expectedFoodName, expectedWeight);
    }

    @AfterEach
    void tearDown() {
        foodInputData = null;
    }

    @Test
    void getName() {
        assertEquals(expectedFoodName, foodInputData.getName());
    }

    @Test
    void getWeight() {
        assertEquals(expectedWeight, foodInputData.getWeight());
    }
}
