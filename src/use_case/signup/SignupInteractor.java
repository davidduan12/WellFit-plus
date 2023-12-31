package use_case.signup;

import entity.User;
import entity.UserFactory;

public class SignupInteractor implements SignupInputBoundary {

    final SignupDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;

    final UserFactory userFactory;


    public SignupInteractor(SignupDataAccessInterface userDataAccessObject, SignupOutputBoundary userPresenter, UserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }
    /**
     * Executes the signup process with the provided input data.
     * validation checks, if successful, user creation and data modification
     *
     * @param signupInputData The input data for signup.
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getWeight(), signupInputData.getHeight());
//            double bmi = user.getWeight() / ((user.getHeight() * 100) * (user.getHeight() * 100));
//            user.setBMI(bmi);
            userDataAccessObject.userWriting(user);
            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }

    }

}
