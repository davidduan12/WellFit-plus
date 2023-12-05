package entity;

public class UserFactory implements UserFactoryInterface{
    public User create(String username, String password, double weight, double height){
        return new User(username, password, weight, height);
    }

}
