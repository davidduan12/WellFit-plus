package use_case.LoggedIn.add_food;

public class AddFoodOutputData {


    private final String food;

    public AddFoodOutputData(String food){
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
