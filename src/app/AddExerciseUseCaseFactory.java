package app;

import interface_adapter.AddExercise.AddExerciseController;
import interface_adapter.AddExercise.AddExercisePresenter;
import interface_adapter.AddExercise.AddExerciseViewModel;
import use_case.UserDataAccessInterface;
import use_case.add_exercise.ExerciseAddDataAccessInterface;
import use_case.add_exercise.AddExerciseInputBoundary;
import use_case.add_exercise.AddExerciseInteractor;
import use_case.add_exercise.AddExerciseOutputBoundary;
import view.ExerciseView;

import javax.swing.*;
import java.io.IOException;

public class AddExerciseUseCaseFactory {
    private AddExerciseUseCaseFactory() {}

    public static ExerciseView create(
            AddExerciseViewModel addExerciseViewModel,
            ExerciseAddDataAccessInterface exerciseDataAccessObject,
            UserDataAccessInterface fileUserDataAccessObject) {
        try {
            AddExerciseController addExerciseController = createAddExerciseUser(addExerciseViewModel, fileUserDataAccessObject, exerciseDataAccessObject);
            return new ExerciseView(addExerciseViewModel, addExerciseController);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Could not open user data file");
        }

        return null;
    }

    private static AddExerciseController createAddExerciseUser(
            AddExerciseViewModel addExerciseViewModel,
            UserDataAccessInterface fileUserDataAccessObject,
            ExerciseAddDataAccessInterface exerciseDataAccessObject
    ) throws IOException {
        AddExerciseOutputBoundary addExerciseOutputBoundary = new AddExercisePresenter(addExerciseViewModel);
        AddExerciseInputBoundary addExerciseInteractor = new AddExerciseInteractor(exerciseDataAccessObject, addExerciseOutputBoundary, fileUserDataAccessObject);
        return new AddExerciseController(addExerciseInteractor);
    }
}