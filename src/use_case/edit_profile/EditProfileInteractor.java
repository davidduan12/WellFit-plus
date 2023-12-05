package use_case.edit_profile;

import use_case.UserDataAccessInterface;

public class EditProfileInteractor implements EditProfileInputBoundary {

    final EditProfiledataAccessInterface userDataAccessInterface;
    final EditProfileOutputBoundary editProfileOutputBoundary;

    public EditProfileInteractor(EditProfiledataAccessInterface u, EditProfileOutputBoundary b){
        userDataAccessInterface = u;
        editProfileOutputBoundary = b;
    }

    @Override
    public void execute(EditProfileInputData inputData){
        userDataAccessInterface.editName(inputData.getName());
        userDataAccessInterface.editPassword(inputData.getPassword());
        userDataAccessInterface.editHeight(inputData.getHeight());
        userDataAccessInterface.editWeight(inputData.getWeight());
        editProfileOutputBoundary.prepareSuccessView();
    }

}
