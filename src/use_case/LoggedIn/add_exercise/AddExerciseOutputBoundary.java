package use_case.LoggedIn.add_exercise;

public interface AddExerciseOutputBoundary {
    // Prepares the view model for a successful exercise addition.
    public void prepareSuccessView(AddExerciseOutputData outputData);
    // Prepares the view model for a failed exercise addition with an error message.
    public void prepareFailView(String error);

}
