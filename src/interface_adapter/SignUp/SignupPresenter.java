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
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
//    public void prepareFailView(String error) {
//        SignupState signupState = signupViewModel.getState();
//        signupState.setUsernameError(error);
//        signupState.setPasswordError(error);
//        signupState.setRepeatPasswordError(error);
//
//        signupViewModel.firePropertyChanged();
//    }
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();

        if (error.equals("User already exists.")) {
            // TODO: Try to test the error of user already exists. I cannot trigger this error when testing by hands.
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
