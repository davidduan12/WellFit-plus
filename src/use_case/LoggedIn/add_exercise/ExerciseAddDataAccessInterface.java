package use_case.LoggedIn.add_exercise;

public interface ExerciseAddDataAccessInterface {
//    boolean existByName(String exerciseName);
    int getCalorieExercise(String exerciseName, float amount);

    double apiExercise(String query);

    //TODO: need to added read write csv here

}
