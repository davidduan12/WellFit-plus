package use_case.login;

public interface LoginInputBoundary {

    // Executes the login process using the provided input data.
    void execute(LoginInputData loginInputData);
}
