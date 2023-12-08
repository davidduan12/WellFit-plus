package use_case.LoggedIn.add_food;

public class AddFoodInputData {

     private String food;
     private double weight;

    public AddFoodInputData(String food, double weight){
        this.food = food;
        this.weight = weight;
    }

    public String getName(){
        return food;
    }

    public double getWeight(){
        return weight;
    }
}
