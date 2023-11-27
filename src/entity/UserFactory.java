package entity;

public class UserFactory implements UserFactoryInterface{
    public User create(String username, String password, int age, double weight, double height, String sex, String name){
        return new User(username, password, age, weight, height, sex, name);
    }

}
