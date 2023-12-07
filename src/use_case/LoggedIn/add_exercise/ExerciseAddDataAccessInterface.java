package use_case.LoggedIn.add_exercise;

import java.util.Map;

public interface ExerciseAddDataAccessInterface {
//    boolean existByName(String exerciseName);
    void writeExerciseCaloriesToCSV(Map<String, Double> foodData, String username);

    double apiExercise(String query);

    //TODO: need to added read write csv here

}
