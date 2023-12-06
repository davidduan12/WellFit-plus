package use_case.LoggedIn.add_exercise;

import use_case.UserDataAccessInterface;

import java.util.ArrayList;

public class AddExerciseInteractor implements AddExerciseInputBoundary{
    final ExerciseAddDataAccessInterface exerciseAddDataAccessInterface;
    final AddExerciseOutputBoundary addExerciseOutputBoundary;
    public AddExerciseInteractor(ExerciseAddDataAccessInterface exerciseAddDataAccessInterface, AddExerciseOutputBoundary addExerciseOutputBoundary){
        this.exerciseAddDataAccessInterface = exerciseAddDataAccessInterface;
        this.addExerciseOutputBoundary = addExerciseOutputBoundary;}

    @Override
    public void execute(AddExerciseInputData inputData) {
        String query = inputData.getDuration() + "minutes of " + inputData.getName();
        Double apiData = exerciseAddDataAccessInterface.apiExercise(query);
//        ArrayList<ArrayList<String>> records = userDataAccessInterface.readToCSV("/data/sample_user.csv");
//        userDataAccessInterface.writeToCSV(records);
        //TODO: Change this to appropirate function
    }
}
