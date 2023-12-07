package use_case.LoggedIn.add_food;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddFoodOutputDataTest {

    private AddFoodOutputData outputData;
    private final String expectedFoodName = "Banana";

    @BeforeEach
    void setUp() {
        outputData = new AddFoodOutputData(expectedFoodName);
    }

    @AfterEach
    void tearDown() {
        outputData = null;
    }

    @Test
    void getFood() {
        assertEquals(expectedFoodName, outputData.getFood());
    }
}
