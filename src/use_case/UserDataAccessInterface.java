package use_case;

import java.util.ArrayList;

public interface UserDataAccessInterface {
    void writeToCSV(String filepath, ArrayList<ArrayList<String>> data);

    ArrayList<ArrayList<String>> readToCSV(String filePath);
}
