package use_case.LoggedIn.add_food;

import java.util.Map;

public interface FoodAddDataAccessInterface {
//    boolean existByName(String foodName);

    void writeFoodCaloriesToCSV(Map<String, Double> foodData, String username);
    double apiNutrient(String query);

    //TODO: need to added read write csv here
}
