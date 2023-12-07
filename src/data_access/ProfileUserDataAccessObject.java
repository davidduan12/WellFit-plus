package data_access;

import entity.User;
import use_case.ProfileUserDataAccessInterface;

public class ProfileUserDataAccessObject implements ProfileUserDataAccessInterface {

    private User user;
    public ProfileUserDataAccessObject(User user){
        this.user = user;
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void setUsername(String username) {
        user.setUsername(username);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public void setPassword(String password) {
        user.setPassword(password);
    }

    @Override
    public double getWeight() {
        return user.getWeight();
    }

    @Override
    public double getHeight() {
        return user.getHeight();
    }

    @Override
    public void setHeight(double height) {
        user.setHeight(height);
    }
}
