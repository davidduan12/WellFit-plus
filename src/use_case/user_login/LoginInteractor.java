package use_case.user_login;


import entity.User;

public class LoginInteractor implements LoginInputBondary {
    private final LoginDataAccessInterface dataAccess;
    private final LoginOutputBoundary outputBoundary;

    public LoginInteractor(LoginDataAccessInterface dataAccess, LoginOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    public void login(String username, String password) {
        if (dataAccess.validateCredentials(username, password)) {
            User user = dataAccess.getUserByUsername(username);
            outputBoundary.onLoginSuccess(user);
        } else {
            outputBoundary.onLoginFailure("Invalid credentials");
        }
    }

    @Override
    public void login(String username, String password, int age, double weight, double height, String sex, double bmi) {
        if (dataAccess.validateCredentials(username, password)) {
            User user = dataAccess.getUserByUsername(username);
            outputBoundary.onLoginSuccess(user);
        } else {
            outputBoundary.onLoginFailure("Invalid credentials");
        }
    }
}