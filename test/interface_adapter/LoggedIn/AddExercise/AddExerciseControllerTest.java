package interface_adapter.LoggedIn.AddExercise;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import use_case.LoggedIn.add_exercise.AddExerciseInputBoundary;
import use_case.LoggedIn.add_exercise.AddExerciseInputData;

public class AddExerciseControllerTest {

    @Test
    public void testExecute() {
        AddExerciseInputBoundary addExerciseInputBoundary = mock(AddExerciseInputBoundary.class);
        AddExerciseController addExerciseController = new AddExerciseController(addExerciseInputBoundary);
        AddExerciseInputData inputData = new AddExerciseInputData("ExerciseName", 100.0f);
        AddExerciseInputData expectedArgument = new AddExerciseInputData("ExerciseName", 100.0f);
        addExerciseController.execute("ExerciseName", 100.0f);
        verify(addExerciseInputBoundary).execute(expectedArgument);
    }
}
