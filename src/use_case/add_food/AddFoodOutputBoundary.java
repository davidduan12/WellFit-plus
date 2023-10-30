package src.use_case.add_food;

public interface AddFoodOutputBoundary {

    public void execute(InputData inputData);


    public void prepareSuccessView(OutputData outputData);

    public void prepareFailView(OutputData outputData);

}
