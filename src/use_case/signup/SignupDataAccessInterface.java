package use_case.signup;

import entity.User;

public interface SignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    public void userWriting(User user);

}
