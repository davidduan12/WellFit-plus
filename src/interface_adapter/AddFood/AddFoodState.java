package interface_adapter.AddFood;

import java.util.ArrayList;

public class AddFoodState {
    private ArrayList food = new ArrayList<>();

    public AddFoodState(AddFoodState copy){
        food = copy.food;
    }

    public AddFoodState(){}

    public void setFood(ArrayList food){
        this.food = food;
    }

    public ArrayList getFood(){
        return food;
    }
}
