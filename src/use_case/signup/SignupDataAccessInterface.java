package use_case.signup;

import entity.User;

public interface SignupDataAccessInterface {
    boolean existsByName(String identifier);


    void userWriting(User user);
}
