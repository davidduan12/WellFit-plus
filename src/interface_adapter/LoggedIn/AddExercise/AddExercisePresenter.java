package interface_adapter.LoggedIn.AddExercise;

import use_case.LoggedIn.add_exercise.AddExerciseOutputBoundary;
import use_case.LoggedIn.add_exercise.AddExerciseOutputData;

public class AddExercisePresenter implements AddExerciseOutputBoundary {
    private final AddExerciseViewModel addExerciseViewModel;
    public AddExercisePresenter(AddExerciseViewModel addExerciseViewModel){
        this.addExerciseViewModel = addExerciseViewModel;
    }

    public void prepareSuccessView(AddExerciseOutputData sports){
        AddExerciseState addExerciseState = addExerciseViewModel.getState();
        addExerciseState.setExerciseName(sports.getSports());
        this.addExerciseViewModel.setState(addExerciseState);
        addExerciseViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        AddExerciseState addExerciseState = addExerciseViewModel.getState();
        addExerciseState.setExerciseError(error);
        addExerciseViewModel.firePropertyChanged();
    }

}
