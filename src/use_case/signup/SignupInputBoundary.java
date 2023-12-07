package use_case.signup;

/**
 * Interface defining the input boundary for the signup use case.
 */
public interface SignupInputBoundary {
    /**
     * Executes the signup process with the given input data.
     * This method is the entry point for the signup process, taking signup input data
     * and triggering the necessary operations for user registration.
     *
     * @param signupInputData The data needed for the signup process
     */
    void execute(SignupInputData signupInputData);

}
