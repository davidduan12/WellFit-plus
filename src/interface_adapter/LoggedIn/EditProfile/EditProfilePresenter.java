package interface_adapter.LoggedIn.EditProfile;

import use_case.LoggedIn.edit_profile.EditProfileOutputBoundary;

public class EditProfilePresenter implements EditProfileOutputBoundary {

    private final EditProfileViewModel editProfileViewModel;

    public EditProfilePresenter(EditProfileViewModel editProfileViewModel){
        this.editProfileViewModel = editProfileViewModel;
    }

    public void prepareSuccessView(){
    }
}
