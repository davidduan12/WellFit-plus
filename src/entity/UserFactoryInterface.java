package entity;

public interface UserFactoryInterface {
    User create(String username, String password, int age, double weight, double height, String sex, String name);

}
