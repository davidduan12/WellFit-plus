package interface_adapter.AddFood;
import use_case.add_food.AddFoodInputBoundary;

public class AddFoodController {
    final AddFoodInputBoundary addFoodUseCaseInteractor;

    public AddFoodController(AddFoodInputBoundary addFoodUseCaseInteractor) {
        this.addFoodUseCaseInteractor = addFoodUseCaseInteractor;
    }

    public void execute(String name, Double calorie){
        InputData inputData = new InputData(name, calorie);

        addFoodUseCaseInteractor.execute(inputData);
    }

}
