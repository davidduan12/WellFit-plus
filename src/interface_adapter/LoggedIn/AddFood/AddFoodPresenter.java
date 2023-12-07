package interface_adapter.LoggedIn.AddFood;
import use_case.LoggedIn.add_food.AddFoodOutputBoundary;
import use_case.LoggedIn.add_food.AddFoodOutputData;

public class AddFoodPresenter implements AddFoodOutputBoundary {
    private final AddFoodViewModel addFoodViewModel;

    public AddFoodPresenter(AddFoodViewModel addFoodViewModel){
        this.addFoodViewModel = addFoodViewModel;
    }

    public void prepareSuccessView(AddFoodOutputData food){
        AddFoodState addFoodState = addFoodViewModel.getState();
        addFoodState.setFood(food.getFood());
        this.addFoodViewModel.setState(addFoodState);
        addFoodViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        AddFoodState addFoodState = addFoodViewModel.getState();
        addFoodState.setFoodError(error);
        addFoodViewModel.firePropertyChanged();
    }


}
