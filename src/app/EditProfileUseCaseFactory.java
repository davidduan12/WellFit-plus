package app;

import interface_adapter.LoggedIn.EditProfile.EditProfileController;
import interface_adapter.LoggedIn.EditProfile.EditProfilePresenter;
import interface_adapter.LoggedIn.EditProfile.EditProfileViewModel;
import use_case.LoggedIn.edit_profile.EditProfileInputData;
import use_case.LoggedIn.edit_profile.EditProfileInteractor;
import use_case.LoggedIn.edit_profile.EditProfileOutputBoundary;
import use_case.LoggedIn.edit_profile.EditProfiledataAccessInterface;
import view.ProfileView;

import javax.swing.*;
import java.io.IOException;

public class EditProfileUseCaseFactory {

    private EditProfileUseCaseFactory(){}

    public static ProfileView create(
            EditProfileViewModel editProfileViewModel,
            EditProfiledataAccessInterface editProfiledataAccessInterface){
        try{
            EditProfileController editProfileController = createEditProfileUser(editProfileViewModel, editProfiledataAccessInterface);
            return new ProfileView(editProfileViewModel, editProfileController);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }
    private static EditProfileController createEditProfileUser(
            EditProfileViewModel editProfileViewModel,
            EditProfiledataAccessInterface editProfiledataAccessInterface
    ) throws IOException {
        EditProfileOutputBoundary editProfileOutputBoundary = new EditProfilePresenter(editProfileViewModel);
        EditProfileInteractor editProfileInteractor = new EditProfileInteractor(editProfiledataAccessInterface, editProfileOutputBoundary);
        return new EditProfileController(editProfileInteractor);
    }
}
