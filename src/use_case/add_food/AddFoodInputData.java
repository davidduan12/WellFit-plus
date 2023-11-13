package use_case.add_food;

public class AddFoodInputData {

    final private String food;

    public AddFoodInputData(String food){
        this.food = food;
    }

    String getFood(){
        return food;
    }
}
