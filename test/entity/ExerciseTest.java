package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ExerciseTest {
    private Exercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new Exercise("Running", 30);
    }

    @AfterEach
    void tearDown() {
        exercise = null;
    }

    @Test
    void getDuration() {
        assertEquals(30, exercise.getDuration());
    }

    @Test
    void setDuration() {
        exercise.setDuration(45);
        assertEquals(45, exercise.getDuration());
    }


    @Test
    void getName() {
        assertEquals("Running", exercise.getName());
    }

    @Test
    void getCaloriesBurnedPerHour() {
        Exercise running = new Exercise("Running", 30);

        float expectedCaloriesBurned = 600;

        float actualCaloriesBurned = running.getCaloriesBurnedPerHour();

        assertEquals(expectedCaloriesBurned, actualCaloriesBurned);
    }
}
