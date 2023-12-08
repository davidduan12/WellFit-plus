package use_case.signup;

/**
 * Interface defining the output boundary for the signup use case.
 * This interface represents the contract for output processing in the signup process,
 */
public interface SignupOutputBoundary {

    /**
     * Prepares the view for a successful signup process.
     * @param user The output data of the successful signup process.
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares the view for a failed signup process.
     *
     * @param error The error message indicating the reason for the failure.
     */
    void prepareFailView(String error);
}
