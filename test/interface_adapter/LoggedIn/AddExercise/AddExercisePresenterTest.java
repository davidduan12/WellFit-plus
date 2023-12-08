package interface_adapter.LoggedIn.AddExercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.LoggedIn.add_exercise.AddExerciseOutputData;

public class AddExercisePresenterTest {

    private AddExercisePresenter presenter;
    private AddExerciseViewModel viewModel;

    @BeforeEach
    public void setUp() {
        viewModel = Mockito.mock(AddExerciseViewModel.class);
        presenter = new AddExercisePresenter(viewModel);
    }

    @Test
    public void testPrepareSuccessView() {
        AddExerciseOutputData outputData = new AddExerciseOutputData("Running");

        presenter.prepareSuccessView(outputData);

        Mockito.verify(viewModel).setState(Mockito.any());
        Mockito.verify(viewModel).firePropertyChanged();
    }

    @Test
    public void testPrepareFailView() {
        String error = "Invalid Input";

        presenter.prepareFailView(error);

        Mockito.verify(viewModel).setState(Mockito.any());
        Mockito.verify(viewModel).firePropertyChanged();
    }

}
