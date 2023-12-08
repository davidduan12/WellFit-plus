package use_case.signup;

import entity.User;

/**
 * Interface for data access operations required in the signup use case.
 * checking if a user already exists and writing new user data.
 */
public interface SignupDataAccessInterface {
    /**
     * Checks if a user with the given identifier already exists.
     *
     * @param identifier username
     * @return true if a user with the given identifier exists, false otherwise.
     */
    boolean existsByName(String identifier);

    /**
     * add a new user to the data storage.
     *
     * @param user The User entity to be written to data storage.
     */
    void userWriting(User user);
}
