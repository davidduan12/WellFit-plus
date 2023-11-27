package use_case.add_food;

public interface AddFoodOutputBoundary {

    public void prepareSuccessView(AddFoodOutputData outputData);


    void prepareFailView(String error);
}
