package use_case.LoggedIn.edit_profile;

public interface EditProfileInputBoundary {
    /**
     * Executes the profile editing process using the provided input data.
     * @param inputData The input data
     */
    public void execute(EditProfileInputData inputData);
}
