package use_case.user_login;

import entity.User;

public interface LoginOutputBoundary {
    void onLoginSuccess(User user);

    void onLoginFailure(String invalid_credentials);
}
