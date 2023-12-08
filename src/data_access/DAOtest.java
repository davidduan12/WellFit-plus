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
//        Map<String, Double> ex = new HashMap<>();
//        ex.put("running", 100.2);
        Map<String, String> fd = new HashMap<>();

//        fileUserDataAccessObject.writeFoodCaloriesToCSV(fd, "tmd");
//        fileUserDataAccessObject.writeExerciseCaloriesToCSV(ex, "tmd");

////        fileUserDataAccessObject.writeFoodCaloriesToCSV(fd, "tmd");
//        System.out.println(fdarr[0]);
//        System.out.println(fdarr[1]);
//        System.out.println();
//        System.out.println(fdarr[0].substring(fdarr[0].indexOf("=")+1));
//        System.out.println(fdarr[1].substring(fdarr[1].indexOf("=")+1, fdarr[1].indexOf("}")));
//        System.out.println();
//        update("./data/test_user.csv");


    }
}
//
//    public static void update(String filepath) throws FileNotFoundException {
//        List<String> lines = new ArrayList<>();
//        String line;
//        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
//            while ((line = reader.readLine()) != null) {
//                lines.add(line);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
//            for (String updatedLine : lines) {
//                writer.write(updatedLine);
//                writer.newLine();
//            }
//            writer.write("hs");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (String str : lines){
//            System.out.println(str);
//        }
//    }
//}
