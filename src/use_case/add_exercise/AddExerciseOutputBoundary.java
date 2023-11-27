package use_case.add_exercise;

public interface AddExerciseOutputBoundary {
    public void prepareSuccessView(AddExerciseOutputData outputData);
    public void prepareFailView(String error);
}
