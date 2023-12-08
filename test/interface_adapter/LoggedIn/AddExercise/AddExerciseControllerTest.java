package interface_adapter.LoggedIn.AddExercise;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LoggedIn.add_exercise.AddExerciseInputBoundary;


public class AddExerciseControllerTest {

    private AddExerciseController addExerciseController;
    private AddExerciseInputBoundary addExerciseInputBoundary;

    @BeforeEach
    public void setUp() {
        addExerciseInputBoundary = mock(AddExerciseInputBoundary.class);
        addExerciseController = new AddExerciseController(addExerciseInputBoundary);
    }

    @Test
    public void testExecute() {
        String exerciseName = "Running";
        float duration = 60.0f;

        addExerciseController.execute(exerciseName, duration);
        verify(addExerciseInputBoundary).execute(argThat(inputData ->
                inputData.getName().equals(exerciseName) && inputData.getDuration() == duration));
    }
}

