package use_case.LoggedIn.add_exercise;

public interface ExerciseAddDataAccessInterface {
    boolean existByName(String exerciseName);
    int getCalorie(String exerciseName, float amount);
}
