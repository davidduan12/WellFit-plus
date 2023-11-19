package use_case.add_food;

public class AddFoodInputData {

    final private String food;
    final private float weight;

    public AddFoodInputData(String food, float weight){
        this.food = food;
        this.weight = weight;
    }

    String getName(){
        return food;
    }
}
