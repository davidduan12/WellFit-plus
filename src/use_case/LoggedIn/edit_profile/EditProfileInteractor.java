package use_case.LoggedIn.edit_profile;

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
