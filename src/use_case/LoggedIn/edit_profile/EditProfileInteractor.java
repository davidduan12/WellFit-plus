package use_case.LoggedIn.edit_profile;

import interface_adapter.LoggedIn.LoggedInViewModel;
import use_case.LoggedIn.add_food.AddFoodOutputData;

public class EditProfileInteractor implements EditProfileInputBoundary {
    /**
     * Interactor class for the 'edit profile' use case, buisiness logic
     */
    final EditProfiledataAccessInterface userDataAccessInterface;
    final LoggedInViewModel loggedInViewModel;
    final EditProfileOutputBoundary editProfileOutputBoundary;

    public EditProfileInteractor(EditProfiledataAccessInterface u, EditProfileOutputBoundary b, LoggedInViewModel l){
        userDataAccessInterface = u;
        loggedInViewModel = l;
        editProfileOutputBoundary = b;
    }

    @Override
    public void execute(EditProfileInputData inputData){
//        userDataAccessInterface.editName(inputData.getName());
//        userDataAccessInterface.editPassword(inputData.getPassword());
//        userDataAccessInterface.editHeight(inputData.getHeight());
//        userDataAccessInterface.editWeight(inputData.getWeight());
        if (userDataAccessInterface.existsByName(inputData.getName())){
            editProfileOutputBoundary.prepareFailView("Username exist, please pick another one");
        }
        else {
            userDataAccessInterface.editUserCsv(inputData, loggedInViewModel.getLoggedInUser());
            EditProfileOutputdata out = new EditProfileOutputdata(inputData.getName(), inputData.getPassword(), inputData.getHeight(), inputData.getWeight(), false);
            editProfileOutputBoundary.prepareSuccessView(out);
        }


    }

}
