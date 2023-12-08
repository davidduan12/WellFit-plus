package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {

    private Exercise exercise;

    @BeforeEach
    public void setUp() {
        // Initialize an Exercise object with sample data for testing
        exercise = new Exercise("Running", 500.0f);
    }

    @Test
    public void testGetName() {
        // Verify that the getName() method returns the expected exercise name
        assertEquals("Running", exercise.getName());
    }

    @Test
    public void testGetCaloriesBurnedPerHour() {

        assertEquals(500.0f, exercise.getCaloriesBurnedPerHour(), 0.001);
    }

    @Test
    public void testGetSetDuration() {
        assertEquals(0.0f, exercise.getDuration(), 0.001);

        exercise.setDuration(30.0f);
        assertEquals(30.0f, exercise.getDuration(), 0.001);
    }
}
