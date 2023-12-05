package interface_adapter.EditProfile;

import use_case.edit_profile.EditProfileOutputBoundary;

public class EditProfilePresenter{

    private final EditProfileViewModel editProfileViewModel;

    public EditProfilePresenter(EditProfileViewModel editProfileViewModel){
        this.editProfileViewModel = editProfileViewModel;
    }

    public void prepareSuccessView(){
    }
}
