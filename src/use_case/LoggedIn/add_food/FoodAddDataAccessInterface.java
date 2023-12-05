package use_case.LoggedIn.add_food;
import entity.Food;

public interface FoodAddDataAccessInterface {
    boolean existByName(String foodName);

    int getCalorie(String foodName, float amount);

    double apiExercise(String query);

    double apiNutrient(String query);
}
