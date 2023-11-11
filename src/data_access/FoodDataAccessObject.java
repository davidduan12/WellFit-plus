package data_access;

import use_case.FoodAddDataAccessInterface;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FoodDataAccessObject implements FoodAddDataAccessInterface {
    private final String csvFilePath;

    public FoodDataAccessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public boolean existByName(String foodName) {
        // Implementation to check if the food exists in the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(foodName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getCalorie(String foodName, float amount) {
        // Implementation to get the calories for the specified amount of food
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(foodName)) {
                    float caloriesPerUnit = Float.parseFloat(values[1]); // Assuming the second value is the calories per unit
                    return Math.round(caloriesPerUnit * amount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
