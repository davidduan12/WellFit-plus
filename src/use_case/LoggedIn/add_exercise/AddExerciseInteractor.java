package use_case.LoggedIn.add_exercise;

import interface_adapter.LoggedIn.LoggedInViewModel;

import java.util.HashMap;
import java.util.Map;

public class AddExerciseInteractor implements AddExerciseInputBoundary {
    final AddExerciseOutputBoundary addExerciseOutputBoundary;
    final LoggedInViewModel loggedInViewModel;
    final ExerciseAddDataAccessInterface userDataAccessInterface;

    public AddExerciseInteractor(LoggedInViewModel loggedInViewModel, AddExerciseOutputBoundary addExerciseOutputBoundary, ExerciseAddDataAccessInterface userDataAccessInterface) {
        this.loggedInViewModel = loggedInViewModel;
        this.addExerciseOutputBoundary = addExerciseOutputBoundary;
        this.userDataAccessInterface = userDataAccessInterface;
    }
    public void execute(AddExerciseInputData inputData){
        String query = inputData.getDuration() + "minutes of " + inputData.getName();
        double calorieData = userDataAccessInterface.apiExercise(query, inputData.getName());
        //first get data from reading the csv
        if (calorieData == -1){
            addExerciseOutputBoundary.prepareFailView("Invalid Input");
        }else{
            Map<String, Double> data = new HashMap<>();
            data.put(inputData.getName(), calorieData);
            userDataAccessInterface.writeExerciseCaloriesToCSV(data, loggedInViewModel.getLoggedInUser());
            AddExerciseOutputData out = new AddExerciseOutputData(inputData.getName());
            addExerciseOutputBoundary.prepareSuccessView(out);
        }
    }
}


