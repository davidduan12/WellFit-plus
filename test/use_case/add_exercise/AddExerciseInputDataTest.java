package use_case.add_exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LoggedIn.add_exercise.AddExerciseInputData;

import static org.junit.jupiter.api.Assertions.*;

class AddExerciseInputDataTest {
    private AddExerciseInputData inputData;

    @BeforeEach
    void setUp() {
        inputData = new AddExerciseInputData("Running", 30);
    }


    @Test
    void getName() {
        assertEquals("Running", inputData.getName());
    }
}