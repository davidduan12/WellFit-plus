package data_access;

import use_case.add_exercise.ExerciseAddDataAccessInterface;

import java.io.*;

public class ExerciseDataAccessObject implements ExerciseAddDataAccessInterface {
    private final String csvFilePath;

    public ExerciseDataAccessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public boolean existByName(String exerciseName) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // 假设CSV文件的第二列是运动名称
                if (values[0].equalsIgnoreCase(exerciseName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getCalorie(String exerciseName, float amount) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equalsIgnoreCase(exerciseName)) {
                    float caloriesPerUnit = Float.parseFloat(values[1]);
                    return Math.round(caloriesPerUnit * amount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
