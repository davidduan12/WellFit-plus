package use_case.login;


import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    private final LoginDataAccessInterface userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginDataAccessInterface dataAccess, LoginOutputBoundary outputBoundary) {
        this.userDataAccessObject = dataAccess;
        this.loginPresenter = outputBoundary;
    }

    /**
     * Executes the login process using the provided login input data.
     * This method typically involves several key steps:
     * Checks if the provided username and password are valid.
     * Uses the userDataAccessObject to verify if the user exists and if the password is correct.
     *    - If the login is successful, call loginPresenter, success view
     *    - If the login fails, failure view
     *
     * @param loginInputData The input data for the login process, containing the username and password.
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }

    }
}
