package data_access;

import entity.User;
import entity.UserFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUserDataAccessObjectTest {

    public static void main(String[] args) throws IOException {
        UserFactory userFactory = new UserFactory();
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("./data/test_user.csv", userFactory);
        User user = new User("tmd", "Ihateschool", 199, 99);
        fileUserDataAccessObject.userWriting(user);
    }


    @org.junit.jupiter.api.Test
    void userWriting() {
    }

    @org.junit.jupiter.api.Test
    void existsByName() {
    }

    @org.junit.jupiter.api.Test
    void userLogin() {
    }

    @org.junit.jupiter.api.Test
    void writeExerciseCaloriesToCSV() {
    }

    @org.junit.jupiter.api.Test
    void writeFoodCaloriesToCSV() {
    }

    @org.junit.jupiter.api.Test
    void editUserCsv() {
    }
}