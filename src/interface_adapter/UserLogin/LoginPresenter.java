package interface_adapter.UserLogin;

import entity.User;
import use_case.user_login.LoginOutputBoundary;

public class LoginPresenter implements LoginOutputBoundary {
    public void presentLoginError(String username_and_password_are_required) {
    }

    @Override
    public void onLoginSuccess(User user) {

    }

    @Override
    public void onLoginFailure(String invalid_credentials) {

    }
}
