package data_access;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileUserDataAccessObject {

    public void writeToCSV(String filePath, Collection data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (Object d : data){
                writer.write((String) d);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readToCSV(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // Process the values as needed
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
