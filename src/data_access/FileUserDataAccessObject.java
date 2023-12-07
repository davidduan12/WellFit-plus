package data_access;
import entity.User;
import entity.UserFactory;
import use_case.LoggedIn.add_exercise.ExerciseAddDataAccessInterface;
import use_case.LoggedIn.add_food.FoodAddDataAccessInterface;
import use_case.LoggedIn.edit_profile.EditProfiledataAccessInterface;

import use_case.LoggedIn.edit_profile.EditProfileInputData;
import use_case.login.LoginDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;
import use_case.signup.SignupOutputData;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.util.ArrayList;


public class FileUserDataAccessObject implements
        FoodAddDataAccessInterface, ExerciseAddDataAccessInterface, EditProfiledataAccessInterface,
        LoginDataAccessInterface, SignupDataAccessInterface {
    private String filepath;

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    private String header;

    public FileUserDataAccessObject(String filepath, UserFactory userFactory) throws IOException {
        this.filepath = filepath;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            header = reader.readLine();
            String row;
            while ((row = reader.readLine()) != null) {
                if (row.equals("")){
                    continue;
                }
                String[] col = row.split(",");
                String username = col[0];
                String password = col[1];
                double height = Double.parseDouble(col[2]);
                double weight = Double.parseDouble(col[3]);
                User user = new User(username, password, height, weight);
                if (!existsByName(username)) {
                    accounts.put(username, user);
                }
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            writer.newLine();
            writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getHeight() + "," + user.getHeight() + "," + "" + "," + "");
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

    public void writeExerciseCaloriesToCSV(Map<String, Double> exerciseData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    if (userData.length < 6) {
                        if (userData.length < 5) {
                            userData = addElement(userData, "");
                        }
                        userData = addElement(userData, "");
                    }

                    userData[5] = userData[5] + exerciseData.toString().replace(',', ';');
                    String[] ex = userData[5].split("}");
                    double totalCalorieExpenditure = this.calculateTotal(ex);
                    User user = accounts.get(username);
                    user.setTotalCaloriesExpenditure(totalCalorieExpenditure);
                    if (userData.length < 8) {
                        if (userData.length < 7) {
                            userData = addElement(userData, "");
                        }
                        userData = addElement(userData, "");
                    }
                    userData[7] = ""+totalCalorieExpenditure;
                }
//                System.out.println(String.join(",", userData));
                lines.add(String.join(",", userData));
            }
//            System.out.println(lines);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                writer.write(header);
                writer.newLine();

                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFoodCaloriesToCSV(Map<String, Double> foodData, String username) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username)) {
                    //if initial food data is empty
                    if (userData.length < 5) {
                        userData = addElement(userData, "");
                    }

                    //so it doesn't             System.out.println(arr[i]);interfere with csv comma
                    userData[4] = userData[4] + foodData.toString().replace(',',';');

                    String[] food = userData[4].split("}");
                    double totalCalorieIntake = this.calculateTotal(food);
                    User user = accounts.get(username);
                    user.setTotalCaloriesIntake(totalCalorieIntake);

                    if (userData.length < 7) {
                        userData = addElement(userData, "");
                    }
                    userData[6] = "" + totalCalorieIntake;
                }
                lines.add(String.join(",", userData));
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                writer.write(header);
                writer.newLine();
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public double calculateTotal(String[] arr){
        double calTotal = 0;

        for (int i =0; i < arr.length;i++){
                System.out.println(arr[i]+ " non last");
                calTotal += Double.parseDouble(arr[i].substring(arr[i].indexOf("=")+1));

        }
        System.out.println(calTotal);
        return calTotal;
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


    public double getCalorieFood(String foodName, double amount) {
        // Implementation to get the calories for the specified amount of food
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(foodName)) {
                    double caloriesPerUnit = Double.parseDouble(values[1]); // Assuming the second value is the calories per unit
                    return Math.round(caloriesPerUnit * amount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getCalorieExercise(String exerciseName, double amount) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(exerciseName)) {
                    double caloriesPerUnit = Double.parseDouble(values[1]);
                    return Math.round(caloriesPerUnit * amount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public double apiExercise(String query, String name) {
        // Call NutritionixAPICaller
        return NutritionixAPICaller.fetchExercise(query, name);
    }

    public double apiNutrient(String query) {
        // Call NutritionixAPICaller
        return NutritionixAPICaller.fetchNutrient(query);
    }

    public void editName(String newName, String oldName) {

    }

    @Override
    public void editName(String newName) {

    }

    public void editWeight(double newWeight) {
        //
    }

    public void editHeight(double newHeight) {
        //
    }

    public void editPassword(String newPassword) {
        //
    }

    public User get(String username) {
        if (existsByName(username)) {
            return accounts.get(username);
        }
        return null;
    }

    public void save(User user) {
        accounts.put(user.getUsername(), user);
    }

    public static String[] addElement(String[] arr, String addElement) {
        String[] newArr = new String[arr.length + 1];
        int i;
        for (i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = addElement;
        return newArr;
    }

    public double getHeight(String username){
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        return Double.parseDouble(userData[2]);
                        }

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }

    public double getWeight(String username){
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        return Double.parseDouble(userData[3]);
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
    public String getFoodHistory(String username) {
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        if (userData.length < 5){
                            return "You have no food history yet";
                        }
                        else {
                           return formatTostring(userData[4]);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "You have no food history yet";
    }

    public String getExerciseHistory(String username) {
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        if (userData.length < 6){
                            return "You have no exercise history yet";
                        }
                        else {
                            return formatTostring(userData[5]);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "You have no excercise history yet";
    }

    public double getTotalIntake(String username){
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        if (userData.length < 7){
                            return 0;
                        }
                        return Math.round(Double.parseDouble(userData[6]));
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
    public double getTotalExpenditure(String username){
        if (existsByName(username)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username)) {
                        if (userData.length < 8){
                            return 0;
                        }
                        return Math.round(Double.parseDouble(userData[7]));
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
    public String formatTostring(String str){
        String[] data = str.split("}");
        String result = "";
        for (String d : data){
            result = result + d.substring(d.indexOf("{")+1,d.indexOf("=")) ;

            result = result + ": " +d.substring(d.indexOf("=")+1) + " Kcals; ";

        }
       return result;
    }

}





