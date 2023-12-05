package entity;

public interface UserFactoryInterface {
    User create(String username, String password, double weight, double height);

}
