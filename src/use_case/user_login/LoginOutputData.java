package use_case.user_login;

public class LoginOutputData {
    private final boolean isSuccess;
    private final String message;
    private final String username;
    public LoginOutputData(boolean isSuccess, String message, String username) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.username = username;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }
}
