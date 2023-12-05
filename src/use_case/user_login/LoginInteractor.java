package use_case.user_login;


import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    private final LoginDataAccessInterface dataAccess;
    private final LoginOutputBoundary outputBoundary;

    public LoginInteractor(LoginDataAccessInterface dataAccess, LoginOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void login(String username, String password) {
        // Attempt to validate the user credentials
        boolean result = dataAccess.validateUserCredentials(username, password);
        LoginOutputData outputData;

        if (result) {
            // If credentials are valid, create success output data
            User user = dataAccess.getUserByUsername(username);
            String successMessage = "Login successful";
            outputData = new LoginOutputData(true, successMessage, user.getUsername());
            outputBoundary.presentLoginSuccess(outputData);
        } else {
            // If credentials are invalid, create failure output data
            String failureMessage = "Login failed. Invalid username or password.";
            outputData = new LoginOutputData(false, failureMessage, username);
            outputBoundary.presentLoginFailure(outputData);
        }
    }

}
