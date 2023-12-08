package use_case.login;

import entity.User;

public interface LoginDataAccessInterface {
    // Checks if a user exists with the given username
    boolean existsByName(String identifier);

    User get(String username);

    // Validates user login with the given username and password.
    public boolean userLogin(String targetUsername, String password);



    }
