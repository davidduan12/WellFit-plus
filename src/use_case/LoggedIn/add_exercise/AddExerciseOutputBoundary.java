package use_case.LoggedIn.add_exercise;

public interface AddExerciseOutputBoundary {
    public void prepareSuccessView(AddExerciseOutputData outputData);
    public void prepareFailView(String error);

}
