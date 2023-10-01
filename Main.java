
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.api-ninjas.com/v1/nutrition?query=fries");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key", "KJOnFglT16Ng4atwCRN8zg==piEs2PAHroE9GVQY");
        connection.setRequestMethod("GET");
        InputStream responseStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseStream));
        String line = bufferedReader.readLine();
        line = line.substring(2,line.length()-2);
        String[] lineSplit = line.split(", ");
        ArrayList<String> output = new ArrayList<>(List.of(lineSplit));
        for (String x : output){
            System.out.println(x);
        }
    }
}