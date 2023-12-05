package data_access;
import entity.User;
import entity.UserFactory;
import use_case.UserDataAccessInterface;

import use_case.edit_profile.EditProfileInputData;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_profile.EditProfiledataAccessInterface;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Float.parseFloat;

public class FileUserDataAccessObject implements UserDataAccessInterface {
    private String filepath;

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String filepath, UserFactory userFactory) throws IOException {
        this.filepath = filepath;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String header = reader.readLine();
            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = col[0];
                String password = col[1];
                double height = Double.parseDouble(col[2]);
                double weight = Double.parseDouble(col[3]);
                User user = new User(username, password, height, weight);
                accounts.put(username, user);
            }
        }
    }



    //need initializer here, we shouldn't be stating filepath everytime we call a function, not CA.
    public void writeToCSV(ArrayList<ArrayList<String>> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.newLine();
            for (ArrayList<String> Arr : data) {
                for (String d : Arr) {
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
    public void userWriting(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.newLine();
            writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getHeight() + "," + user.getHeight() + "," + ",");
            accounts.put(user.getUsername(), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return whether a user exists with username identifier.
     *
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */

    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }


    //sign up
    public boolean userLogin(String targetUsername, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(targetUsername)) {
                    if (userData[1].equals(password)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void writeExerciseCaloriesToCSV(Map<String, String> exerciseData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    userData[5] = userData[5] + exerciseData.toString();
                    String[] ex = userData[5].split(",");
                    String tce = ex[1].replace("}", "");
                    float totalCalorieExpenditure = parseFloat(tce);
                    User user = accounts.get(username);
                    user.setTotalCaloriesExpenditure(user.getTotalCaloriesExpenditure() + totalCalorieExpenditure);
                }
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFoodCaloriesToCSV(Map<String, String> foodData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    userData[4] = userData[4] + foodData.toString();
                }
                String[] food = userData[4].split(",");
                String tci = food[1].replace("}", "");
                float totalCalorieIntake = parseFloat(tci);
                User user = accounts.get(username);
                user.setTotalCaloriesExpenditure(user.getTotalCaloriesIntake() + totalCalorieIntake);
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editUserCsv(EditProfileInputData editProfileInputData, String username) {
        User thisUser;
        thisUser = accounts.get(username);
        thisUser.setUsername(editProfileInputData.getName());
        thisUser.setPassword(editProfileInputData.getPassword());
        thisUser.setHeight(editProfileInputData.getHeight());
        thisUser.setWeight(editProfileInputData.getWeight());
        accounts.put(editProfileInputData.getName(), thisUser);
        if (!editProfileInputData.getName().equals(username)) {
            accounts.remove(username);
        }

        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    userData[0] = editProfileInputData.getName();
                    userData[1] = editProfileInputData.getPassword();
                    userData[2] = Double.toString(editProfileInputData.getHeight());
                    userData[3] = Double.toString(editProfileInputData.getWeight());
                }
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}



