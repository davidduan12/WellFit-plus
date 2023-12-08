package data_access;

import entity.User;
import entity.UserFactory;
import use_case.LoggedIn.edit_profile.EditProfileInputData;
import use_case.LoggedIn.edit_profile.EditProfileOutputdata;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;

public class DAOtest {
    public static void main(String[] args) throws IOException {
        UserFactory userFactory = new UserFactory();
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("./data/test_user.csv", userFactory);
        User user = new User("tmd", "Ihateschool", 199, 99);
        fileUserDataAccessObject.userWriting(user);
        EditProfileInputData editProfileInputData = new EditProfileInputData("TT", "12", 200, 2);
        fileUserDataAccessObject.editUserCsv(editProfileInputData, "tmd");
        Map<String, String> fd = new HashMap<>();



    }
}