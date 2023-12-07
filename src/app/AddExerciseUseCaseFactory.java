package app;

import interface_adapter.LoggedIn.AddExercise.AddExerciseController;
import interface_adapter.LoggedIn.AddExercise.AddExercisePresenter;
import interface_adapter.LoggedIn.AddExercise.AddExerciseViewModel;
import interface_adapter.LoggedIn.LoggedInViewModel;
import use_case.LoggedIn.add_exercise.ExerciseAddDataAccessInterface;
import use_case.LoggedIn.add_exercise.AddExerciseInputBoundary;
import use_case.LoggedIn.add_exercise.AddExerciseInteractor;
import use_case.LoggedIn.add_exercise.AddExerciseOutputBoundary;
import use_case.UserDataAccessInterface;
import view.ExerciseView;

import javax.swing.*;
import java.io.IOException;

public class AddExerciseUseCaseFactory {
    private AddExerciseUseCaseFactory() {}

    public static ExerciseView create(
            AddExerciseViewModel addExerciseViewModel,
            LoggedInViewModel loggedInViewModel,
            ExerciseAddDataAccessInterface exerciseDataAccessObject) {
        try {
            AddExerciseController addExerciseController = createAddExerciseUser(addExerciseViewModel, loggedInViewModel, exerciseDataAccessObject);
            return new ExerciseView(addExerciseViewModel, addExerciseController);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open user data file");
        }

        return null;
    }

    private static AddExerciseController createAddExerciseUser(
            AddExerciseViewModel addExerciseViewModel,
            LoggedInViewModel loggedInViewModel,
            ExerciseAddDataAccessInterface exerciseAddDataAccessInterface
    ) throws IOException {
        AddExerciseOutputBoundary addExerciseOutputBoundary = new AddExercisePresenter(addExerciseViewModel);
        AddExerciseInputBoundary addExerciseInteractor = new AddExerciseInteractor(loggedInViewModel, addExerciseOutputBoundary, exerciseAddDataAccessInterface);
        return new AddExerciseController(addExerciseInteractor);
    }
}