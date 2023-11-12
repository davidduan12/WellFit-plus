package use_case;
import entity.User;


public interface UserLoginDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
