package use_case;
import entity.Food;

public interface FoodAddDataAccessInterface {
    boolean existByName(String foodName);

    int getCalorie(String foodName, float amount);
}
