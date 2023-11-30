package use_case.user_login;

import entity.User;

public interface LoginDataAccessInterface {
    boolean validateCredentials(String username, String password);

    User getUserByUsername(String username);

    boolean userExists(String username);

    void createUserSession(User user);
    void saveUser(User user);
    void updateUserLoginState(User user);

    boolean validateUserCredentials(String username, String password);
}
