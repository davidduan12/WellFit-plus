package data_access;
import use_case.UserDataAccessInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileUserDataAccessObject implements UserDataAccessInterface {

    //need initializer here, we shouldn't be stating filepath everytime we call a function, not CA.
    public void writeToCSV(String filePath, ArrayList<ArrayList<String>> data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
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

    public ArrayList<ArrayList<String>> readToCSV(String filePath){
        ArrayList<ArrayList<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
}

