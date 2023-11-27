package interface_adapter.UserLogin;
import use_case.user_login.LoginInputBondary;

public class LoginController {
    private final LoginInputBondary loginInteractor;
    private final LoginPresenter loginPresenter;

    public LoginController(LoginInputBondary loginInteractor, LoginPresenter loginPresenter) {
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
