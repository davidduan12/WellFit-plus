package interface_adapter.LoggedIn.EditProfile;

import use_case.LoggedIn.edit_profile.EditProfileOutputBoundary;
import use_case.LoggedIn.edit_profile.EditProfileOutputdata;

public class EditProfilePresenter implements EditProfileOutputBoundary {

    private final EditProfileViewModel editProfileViewModel;

    public EditProfilePresenter(EditProfileViewModel editProfileViewModel){
        this.editProfileViewModel = editProfileViewModel;
    }

//    public void prepareSuccessView(){
//    }

    @Override
    public void prepareSuccessView(EditProfileOutputdata editProfileOutputdata) {
        EditProfileState editProfileState = editProfileViewModel.getState();
        editProfileState.setHeight(editProfileOutputdata.getHeight());
        editProfileState.setUsername(editProfileOutputdata.getUsername());
        editProfileState.setPassword(editProfileOutputdata.getPassword());
        editProfileState.setWeight(editProfileState.getWeight());
        this.editProfileViewModel.setState(editProfileState);
        editProfileViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error){
        EditProfileState editProfileState = editProfileViewModel.getState();
        editProfileState.setEditProfileError(error);
        editProfileViewModel.firePropertyChanged();
    }
}
