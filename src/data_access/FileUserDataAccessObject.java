package data_access;
import entity.User;
import use_case.UserDataAccessInterface;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_profile.EditProfiledataAccessInterface;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;

public class FileUserDataAccessObject implements UserDataAccessInterface {
    private String filepath;

    private final Map<String, User> accounts = new HashMap<>();

    public FileUserDataAccessObject(String filepath){
        this.filepath = filepath;
    }

    //need initializer here, we shouldn't be stating filepath everytime we call a function, not CA.
    public void writeToCSV(ArrayList<ArrayList<String>> data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
            writer.newLine();
            for (ArrayList<String> Arr : data){
                for (String d : Arr){
                    writer.write(d + ",");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<ArrayList<String>> readToCSV(String filePath) {
        ArrayList<ArrayList<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(",")));
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    //sign up
    public void userWriting(User user){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.newLine();
            writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getHeight() + "," + user.getHeight() + "," + ",");
            accounts.put(user.getUsername(), user);
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */

    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }


    //sign up
    public boolean userLogin(String targetUsername, String password){
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null){
                String[] userData = line.split(",");
                if (userData[0].equals(targetUsername)){
                    if (userData[1].equals(password)){
                        return true;
                    }
                }
            }
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void writeExerciseCaloriesToCSV(Map<String, String> exerciseData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null){
                String[] userData = line.split(",");
                if (userData[0].equals(username)){
                    userData[5] = userData[5] + exerciseData.toString();
                }
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFoodCaloriesToCSV(Map<String, String> foodData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null){
                String[] userData = line.split(",");
                if (userData[0].equals(username)){
                    userData[4] = userData[4] + foodData.toString();
                }
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

