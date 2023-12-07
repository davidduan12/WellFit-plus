package data_access;

import entity.User;
import use_case.ProfileUserDataAccessInterface;

public class ProfileUserDataAccessObject implements ProfileUserDataAccessInterface {

    private String username;
    public ProfileUserDataAccessObject(String username){
        this.username = username;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }




}
