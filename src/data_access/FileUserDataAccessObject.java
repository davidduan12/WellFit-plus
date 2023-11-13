package data_access;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;


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
}
