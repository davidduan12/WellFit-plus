package interface_adapter.SignUp;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class SignupController {
    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2, double weight, double height) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, weight, height);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
