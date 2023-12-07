package interface_adapter.LoggedIn.AddExercise;

import use_case.LoggedIn.add_exercise.AddExerciseInputBoundary;
import use_case.LoggedIn.add_exercise.AddExerciseInputData;

public class AddExerciseController {
    final AddExerciseInputBoundary addExerciseUseCaseInteractor;

    public AddExerciseController(AddExerciseInputBoundary addExerciseUseCaseInteractor){
        this.addExerciseUseCaseInteractor = addExerciseUseCaseInteractor;
    }

    public void execute(String name, float calorie){
        AddExerciseInputData inputData = new AddExerciseInputData(name, calorie);
        addExerciseUseCaseInteractor.execute(inputData);
    }

}
