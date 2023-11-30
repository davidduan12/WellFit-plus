package use_case.user_login;

import use_case.user_login.LoginOutputData;

public interface LoginOutputBoundary {
    void presentLoginSuccess(LoginOutputData outputData);
    void presentLoginFailure(LoginOutputData outputData);
}
