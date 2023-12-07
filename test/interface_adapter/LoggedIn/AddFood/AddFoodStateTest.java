package interface_adapter.LoggedIn.AddFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddFoodStateTest {

    @Test
    void testGettersAndSetters() {
        AddFoodState state = new AddFoodState();
        state.setFood("Apple");
        state.setFoodWeight(100);
        state.setFoodError("Invalid input");

        assertEquals("Apple", state.getFood());
        assertEquals(100, state.getFoodWeight());
        assertEquals("Invalid input", state.getFoodError());
    }

    @Test
    void testCopyConstructor() {
        AddFoodState original = new AddFoodState();
        original.setFood("Banana");
        original.setFoodWeight(150);
        original.setFoodError("None");  // Explicitly set this to "None"

        AddFoodState copy = new AddFoodState(original);

        assertEquals(original.getFood(), copy.getFood());
        assertEquals(original.getFoodWeight(), copy.getFoodWeight());
        assertEquals(null, copy.getFoodError());  // Expecting "None" here
    }

}
