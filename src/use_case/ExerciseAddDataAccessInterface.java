package use_case;
import entity.Exercise;


public interface ExerciseAddDataAccessInterface {
    boolean existByName(String exerciseName);

    int getCalorie(String exerciseName, float amount);
}
