package interface_adapter.login;

public class LoginState {
    private String username = "";
    private String error = null;
    private String password = "";

    public LoginState(LoginState copy) {
        username = copy.username;
        error = copy.error;
        password = copy.password;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoginState() {}

    public String getUsername() {
        return username;
    }

    public String getError() {
        return error;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setError(String error) {
        this.error = error;
    }
}
