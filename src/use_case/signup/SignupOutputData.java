package use_case.signup;

public class SignupOutputData {
    private final String username;

    private boolean useCaseFailed;


    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
