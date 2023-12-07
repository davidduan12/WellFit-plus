package app;

import data_access.FileUserDataAccessObject;
import data_access.ProfileUserDataAccessObject;
import entity.UserFactory;
import interface_adapter.LoggedIn.EditProfile.EditProfileController;
import interface_adapter.LoggedIn.EditProfile.EditProfilePresenter;
import interface_adapter.LoggedIn.EditProfile.EditProfileViewModel;
import interface_adapter.LoggedIn.LoggedInViewModel;
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
            LoggedInViewModel loggedInViewModel,
            EditProfiledataAccessInterface editProfiledataAccessInterface){
        try{
            EditProfileController editProfileController = createEditProfileUser(editProfileViewModel, loggedInViewModel, editProfiledataAccessInterface);
            FileUserDataAccessObject fileUserDataAccessObject;
            UserFactory userFactory = new UserFactory();
            fileUserDataAccessObject = new FileUserDataAccessObject("./data/user.csv", userFactory);
            ProfileUserDataAccessObject profileUserDataAccessObject = new ProfileUserDataAccessObject(loggedInViewModel.getLoggedInUser());
            return new ProfileView(editProfileViewModel, editProfileController, fileUserDataAccessObject, profileUserDataAccessObject);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;
    }
    private static EditProfileController createEditProfileUser(
            EditProfileViewModel editProfileViewModel,
            LoggedInViewModel loggedInViewModel,
            EditProfiledataAccessInterface editProfiledataAccessInterface
    ) throws IOException {
        EditProfileOutputBoundary editProfileOutputBoundary = new EditProfilePresenter(editProfileViewModel);
        EditProfileInteractor editProfileInteractor = new EditProfileInteractor(editProfiledataAccessInterface, editProfileOutputBoundary, loggedInViewModel);
        return new EditProfileController(editProfileInteractor);
    }
}
