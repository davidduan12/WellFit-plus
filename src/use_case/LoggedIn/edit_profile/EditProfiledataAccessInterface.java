package use_case.LoggedIn.edit_profile;

public interface EditProfiledataAccessInterface {

    void editName(String newName);

    void editWeight(double newWeight);

    void editHeight(double newHeight);

    void editPassword(String newPassword);
}
