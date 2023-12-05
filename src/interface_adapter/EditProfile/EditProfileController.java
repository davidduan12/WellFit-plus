package interface_adapter.EditProfile;

import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInputData;
import use_case.edit_profile.EditProfileInteractor;

public class EditProfileController {
    final EditProfileInputBoundary editProfileInputBoundary;

    public EditProfileController(EditProfileInputBoundary editProfileInputBoundary){
        this.editProfileInputBoundary = editProfileInputBoundary;
    }

    public void execute(String name, String password, double weight, double height){
        EditProfileInputData inputData = new EditProfileInputData(name, password, weight, height);
        editProfileInputBoundary.execute(inputData);
    }

}
