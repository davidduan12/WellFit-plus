package interface_adapter.LoggedIn.AddExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddExerciseStateTest {
    private AddExerciseState addExerciseState;

    @BeforeEach
    public void setUp() {
        addExerciseState = new AddExerciseState();
    }

    @Test
    public void testDefaultValues() {
        assertEquals("", addExerciseState.getExerciseName());
        assertEquals(0, addExerciseState.getExerciseLength());
        assertEquals(null, addExerciseState.getExerciseError());
    }

    @Test
    public void testSetExerciseName() {
        addExerciseState.setExerciseName("Running");
        assertEquals("Running", addExerciseState.getExerciseName());
    }

    @Test
    public void testSetExerciseLength() {
        addExerciseState.setExerciseLength(30.0);
        assertEquals(30.0, addExerciseState.getExerciseLength(), 0.01); // Allowing for a small double precision difference
    }

    @Test
    public void testSetExerciseError() {
        addExerciseState.setExerciseError("Invalid input");
        assertEquals("Invalid input", addExerciseState.getExerciseError());
    }
}
