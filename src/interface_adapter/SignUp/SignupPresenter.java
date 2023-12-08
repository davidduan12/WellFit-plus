package interface_adapter.SignUp;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

import javax.swing.*;

public class SignupPresenter implements SignupOutputBoundary {
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override

    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();

        if (error.equals("User already exists.")) {
            JOptionPane.showMessageDialog(null, "Name exists. Please choose a different username.");
            signupState.setUsernameError("Name exists");
        } else if (error.equals("Passwords don't match.")) {
            JOptionPane.showMessageDialog(null, "Passwords don't match. Please check your password entries.");
            signupState.setPasswordError("Passwords don't match.");
            signupState.setRepeatPasswordError("Passwords don't match.");
        } else {
            JOptionPane.showMessageDialog(null, error);
            signupState.setUsernameError(error);
            signupState.setPasswordError(error);
            signupState.setRepeatPasswordError(error);
        }

        signupViewModel.firePropertyChanged();
    }
}
