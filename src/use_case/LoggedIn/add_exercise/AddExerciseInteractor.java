package use_case.LoggedIn.add_exercise;

import use_case.UserDataAccessInterface;

import java.util.ArrayList;

public class AddExerciseInteractor implements AddExerciseInputBoundary {
    final ExerciseAddDataAccessInterface exerciseAddDataAccessInterface;
    final AddExerciseOutputBoundary addExerciseOutputBoundary;
    final UserDataAccessInterface userDataAccessInterface;

    public AddExerciseInteractor(ExerciseAddDataAccessInterface exerciseAddDataAccessInterface, AddExerciseOutputBoundary addExerciseOutputBoundary, UserDataAccessInterface userDataAccessInterface) {
        this.exerciseAddDataAccessInterface = exerciseAddDataAccessInterface;
        this.addExerciseOutputBoundary = addExerciseOutputBoundary;
        this.userDataAccessInterface = userDataAccessInterface;
    }



    @Override
    public void execute(AddExerciseInputData inputData) {
        String query = inputData.getDuration() + "minutes of " + inputData.getName();
        Double apiData = exerciseAddDataAccessInterface.apiExercise(query);
//        ArrayList<ArrayList<String>> records = userDataAccessInterface.readToCSV("/data/sample_user.csv");
//        userDataAccessInterface.writeToCSV(records);

        ArrayList<ArrayList<String>> records = userDataAccessInterface.readToCSV("./data/user.csv");
        ArrayList<String> exerciseData = new ArrayList<>();
        exerciseData.add(inputData.getName());
        exerciseData.add(String.valueOf(inputData.getDuration()));
        exerciseData.add(String.valueOf(apiData));
        records.add(exerciseData);

        // Write the updated records back to CSV
        userDataAccessInterface.writeToCSV(records);

        // TODO: Notify the output boundary (UI, presenter, etc.) about the success
    }
}

