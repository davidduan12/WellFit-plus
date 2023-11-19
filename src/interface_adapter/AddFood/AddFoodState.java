package interface_adapter.AddFood;

import java.util.ArrayList;

public class AddFoodState {
    private String foodName = "";
    private float foodWeight = 0;


    public AddFoodState(AddFoodState copy){
        foodName = copy.foodName;
        foodWeight = copy.foodWeight;
    }

    public AddFoodState(){}

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(float foodWeight) {
        this.foodWeight = foodWeight;
    }

}
