package use_case.LoggedIn.add_exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddExerciseInputDataTest {

    @Test
    void testAddExerciseInputData() {
        String expectedSport = "Running";
        double expectedDuration = 30.0;

        AddExerciseInputData exerciseData = new AddExerciseInputData(expectedSport, expectedDuration);

        assertEquals(expectedSport, exerciseData.getName());
        assertEquals(expectedDuration, exerciseData.getDuration());
    }
}
