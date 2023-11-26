package use_case.add_food;

public class AddFoodInputData {

    final private String food;
    final private double weight;

    public AddFoodInputData(String food, double weight){
        this.food = food;
        this.weight = weight;
    }

    String getName(){
        return food;
    }

    double getWeight(){
        return weight;
    }
}
