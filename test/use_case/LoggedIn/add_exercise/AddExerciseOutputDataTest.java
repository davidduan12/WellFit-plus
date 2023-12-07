package use_case.LoggedIn.add_exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddExerciseOutputDataTest {

    @Test
    void testGetSports() {
        String expectedSport = "Cycling";

        AddExerciseOutputData outputData = new AddExerciseOutputData(expectedSport);

        assertEquals(expectedSport, outputData.getSports());
    }
}
