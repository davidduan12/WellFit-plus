package interface_adapter.LoggedIn.AddFood;

public class AddFoodState {
    private String food = "";
    private float foodWeight = 0;

    private String foodError = null;

    public AddFoodState(AddFoodState copy){
        food = copy.food;
        foodWeight = copy.foodWeight;
    }

    public AddFoodState(){}

    public String getFood() {
        return food;
    }

    public void setFood(String foodName) {
        this.food = foodName;
    }

    public float getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(float foodWeight) {
        this.foodWeight = foodWeight;
    }

    public String getFoodError() {
        return foodError;
    }

    public void setFoodError(String foodError) {
        this.foodError = foodError;
    }
}
