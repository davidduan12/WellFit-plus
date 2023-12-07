package use_case.LoggedIn.edit_profile;

public interface EditProfiledataAccessInterface {

    /**
     * Updates the user's name in the data storage.
     * @param newName The new name
     */
    void editName(String newName);

    /**
     * Updates the user's weight in the data storage.
     * @param newWeight The new weight
     */
    void editWeight(double newWeight);

    /**
     * Updates the user's height in the data storage.
     * @param newHeight The new height
     */
    void editHeight(double newHeight);

    /**
     * Updates the user's password in the data storage.
     * @param newPassword The new password
     */
    void editPassword(String newPassword);
}
