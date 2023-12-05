package app;

import interface_adapter.UserLogin.LoginController;
import interface_adapter.UserLogin.LoginPresenter;
import interface_adapter.UserLogin.LoginViewModel;
import use_case.UserDataAccessInterface;
import use_case.user_login.LoginInputBondary;
import use_case.user_login.LoginInteractor;
import use_case.user_login.LoginOutputBoundary;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginController create(
            LoginViewModel loginViewModel,
            UserDataAccessInterface userDataAccessInterface
    ) {
        LoginOutputBoundary loginPresenter = new LoginPresenter(loginViewModel);
        LoginInputBondary loginInteractor = new LoginInteractor(
                userDataAccessInterface,
                loginPresenter
        );

        return new LoginController(loginInteractor, loginPresenter);
    }

    // ... any additional factory methods or configuration
}

