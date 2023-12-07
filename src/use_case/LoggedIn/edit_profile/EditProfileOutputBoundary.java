package use_case.LoggedIn.edit_profile;

/**
 * output boundary for editing user profiles.
 */
public interface EditProfileOutputBoundary {
    public void prepareSuccessView(EditProfileOutputdata editProfileOutputdata);

    public void prepareFailView(String error);
}
