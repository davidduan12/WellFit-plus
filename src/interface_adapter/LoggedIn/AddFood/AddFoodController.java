package interface_adapter.LoggedIn.AddFood;
import use_case.LoggedIn.add_food.AddFoodInputBoundary;
import use_case.LoggedIn.add_food.AddFoodInputData;

public class AddFoodController {
    final AddFoodInputBoundary addFoodUseCaseInteractor;

    public AddFoodController(AddFoodInputBoundary addFoodUseCaseInteractor) {

        this.addFoodUseCaseInteractor = addFoodUseCaseInteractor;
    }

    public void execute(String name, double calorie){
        AddFoodInputData inputData = new AddFoodInputData(name, calorie);
        addFoodUseCaseInteractor.execute(inputData);
    }

}
