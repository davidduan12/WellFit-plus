package use_case.LoggedIn.add_food;

public interface FoodAddDataAccessInterface {
//    boolean existByName(String foodName);

    int getCalorieFood(String foodName, float amount);

    double apiNutrient(String query);

    //TODO: need to added read write csv here
}
