package use_case.LoggedIn.add_exercise;

import use_case.UserDataAccessInterface;

import java.util.ArrayList;

public class AddExerciseInteractor implements AddExerciseInputBoundary{
    final ExerciseAddDataAccessInterface exerciseAddDataAccessInterface;
    final AddExerciseOutputBoundary addExerciseOutputBoundary;
    final UserDataAccessInterface userDataAccessInterface;
    public AddExerciseInteractor(ExerciseAddDataAccessInterface exerciseAddDataAccessInterface, AddExerciseOutputBoundary addExerciseOutputBoundary, UserDataAccessInterface userDataAccessInterface){
        this.exerciseAddDataAccessInterface = exerciseAddDataAccessInterface;
        this.addExerciseOutputBoundary = addExerciseOutputBoundary;
        this.userDataAccessInterface = userDataAccessInterface;
    }

    @Override
    public void execute(AddExerciseInputData inputData) {
        String query = inputData.getName();
        String apiData = exerciseAddDataAccessInterface.fetchDataFromNutritionix(query);
        ArrayList<ArrayList<String>> records = userDataAccessInterface.readToCSV("/data/sample_user.csv");
        userDataAccessInterface.writeToCSV(records);
    }
}
