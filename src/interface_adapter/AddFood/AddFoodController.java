package interface_adapter.AddFood;
import use_case.add_food.AddFoodInputBoundary;
import use_case.add_food.AddFoodInputData;

public class AddFoodController {
    final AddFoodInputBoundary addFoodUseCaseInteractor;

    public AddFoodController(AddFoodInputBoundary addFoodUseCaseInteractor) {
        this.addFoodUseCaseInteractor = addFoodUseCaseInteractor;
    }

    public void execute(String name, float calorie){
        AddFoodInputData inputData = new AddFoodInputData(name, calorie);
        addFoodUseCaseInteractor.execute(inputData);
    }

}
