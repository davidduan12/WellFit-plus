package use_case.add_exercise;

import use_case.LoggedIn.add_exercise.AddExerciseInteractor;
import use_case.LoggedIn.add_exercise.AddExerciseInputData;
import use_case.LoggedIn.add_exercise.AddExerciseOutputBoundary;
import interface_adapter.LoggedIn.LoggedInViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.LoggedIn.add_exercise.ExerciseAddDataAccessInterface;

public class AddExerciseInteractorTest {

    private AddExerciseInteractor interactor;
    private AddExerciseOutputBoundary outputBoundary;
    private LoggedInViewModel loggedInViewModel;

    @BeforeEach
    public void setUp() {
        outputBoundary = Mockito.mock(AddExerciseOutputBoundary.class);
        loggedInViewModel = Mockito.mock(LoggedInViewModel.class);
        ExerciseAddDataAccessInterface userDataAccessInterface = Mockito.mock(ExerciseAddDataAccessInterface.class);
        interactor = new AddExerciseInteractor(loggedInViewModel, outputBoundary, userDataAccessInterface);
    }

    @Test
    public void testExecuteWithValidInput() {
        // Prepare test data
        AddExerciseInputData inputData = new AddExerciseInputData("Running",30.0);

        ExerciseAddDataAccessInterface userDataAccessInterface = null;
        Mockito.when(userDataAccessInterface.apiExercise("30.0 minutes of Running", "Running"))
                .thenReturn(150.0);

        interactor.execute(inputData);

        Mockito.verify(outputBoundary).prepareSuccessView(Mockito.any());
    }

}
