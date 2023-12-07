package app;


import entity.UserFactory;
import interface_adapter.*;
import interface_adapter.SignUp.SignupController;
import interface_adapter.SignUp.SignupPresenter;
import interface_adapter.SignUp.SignupViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupDataAccessInterface;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.SignUpView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignUpView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignupDataAccessInterface userDataAccessObject) {


        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignUpView(signupController, signupViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignupDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new UserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }


}
