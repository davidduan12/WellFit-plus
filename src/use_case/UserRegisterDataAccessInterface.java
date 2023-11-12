package use_case;
import entity.User;

public interface UserRegisterDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
