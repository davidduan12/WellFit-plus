package use_case.add_exercise;

public interface ExerciseAddDataAccessInterface {
    boolean existByName(String exerciseName);
    int getCalorie(String exerciseName, float amount);
    String fetchDataFromNutritionix(String query);
}
