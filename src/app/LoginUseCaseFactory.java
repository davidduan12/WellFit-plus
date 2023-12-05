package app;

import entity.UserFactory;
import interface_adapter.UserLogin.LoginViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.UserLogin.LoginController;
import interface_adapter.UserLogin.LoginPresenter;
import use_case.UserDataAccessInterface;
import use_case.user_login.LoginDataAccessInterface;
import use_case.user_login.LoginInputBoundary;
import use_case.user_login.LoginInteractor;
import use_case.user_login.LoginOutputBoundary;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            UserDataAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            UserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loginViewModel);

        UserFactory userFactory = new UserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                (LoginDataAccessInterface) userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}