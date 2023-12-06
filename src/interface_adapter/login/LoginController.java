package interface_adapter.login;
import use_case.login.LoginInputBondary;
import use_case.login.LoginInputBoundary;

public class LoginController {
    private final LoginInputBoundary loginInteractor;
    private final LoginPresenter loginPresenter;

    public LoginController(LoginInputBoundary loginInteractor, LoginPresenter loginPresenter) {
        this.loginInteractor = loginInteractor;
        this.loginPresenter = loginPresenter;
    }

    public void loginRequest(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            // Handle input validation failure
            loginPresenter.presentLoginError("Username and password are required");
        } else {
            try {
                loginInteractor.login(username, password);
            } catch (Exception e) {
                loginPresenter.presentLoginError(e.getMessage());
            }
        }
    }
}