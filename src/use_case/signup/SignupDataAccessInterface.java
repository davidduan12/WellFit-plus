package use_case.signup;

import entity.User;

public interface SignupDataAccessInterface {
    boolean existsByName(String identifier);

<<<<<<< HEAD
    void save(User user);

    public void userWriting(User user);

=======
    void userWriting(User user);
>>>>>>> 50652269c53eed0ffeecf58549d7973c9fb51321
}
