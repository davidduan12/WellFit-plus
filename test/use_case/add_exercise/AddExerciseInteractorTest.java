package use_case.add_exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LoggedIn.add_exercise.AddExerciseInteractor;
import use_case.LoggedIn.add_exercise.AddExerciseOutputBoundary;
import use_case.LoggedIn.add_exercise.ExerciseAddDataAccessInterface;
import use_case.UserDataAccessInterface;
/**
 * Interactor class for the 'add exercise' use case.
 * It communicates with output boundaries, view models, and data access interfaces.
 */
class AddExerciseInteractorTest {
    private AddExerciseInteractor interactor;
    private ExerciseAddDataAccessInterface exerciseAddDataAccessInterface;
    private AddExerciseOutputBoundary addExerciseOutputBoundary;
    private UserDataAccessInterface userDataAccessInterface;


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
    }
}