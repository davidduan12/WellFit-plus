package interface_adapter.AddFood;
import src.use_case.add_food.AddFoodOutputBoundary;

public class AddFoodPresenter implements AddFoodOutputBoundary {
    private final AddFoodViewModel addFoodViewModel;

    public AddFoodPresenter(AddFoodViewModel addFoodViewModel){
        this.addFoodViewModel = addFoodViewModel;
    }

    public void prepareSuccessView(OutputData food){
        AddFoodState addFoodState = addFoodViewModel.getState();
        addFoodState.setFood(food.getname());
        this.addFoodViewModel.setAddState(addFoodState);
        addFoodViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(OutputData outputData) {
        // I think it should be String error in the parameter instead of Output Data.
        // Should check it in AddFood OutputBoundary.
    }

    public void prepareFailView(String error){
        AddFoodState addFoodState = addFoodViewModel.getState();
        addFoodState.setFoodError(error);
        addFoodViewModel.firePropertyChanged();
    }


}
