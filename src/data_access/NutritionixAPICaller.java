package data_access;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class NutritionixAPICaller {
    private static final String API_ENDPOINT_EXERCISE = "https://trackapi.nutritionix.com/v2/natural/exercise";
    private static final String API_ENDPOINT_NUTRIENT = "https://trackapi.nutritionix.com/v2/natural/nutrients";
    private static final String API_KEY = "36950e27031466b64fcd4d0a977d6953";

    public static double fetchExercise(String query){
        try {
            URL url = new URL(API_ENDPOINT_EXERCISE);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-app-id", "80e22ff8");
            connection.setRequestProperty("x-app-key", API_KEY);

            // Set input and output streams to true
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set the request body
            String requestBody = "{ \"query\": \"" + query + "\" }";
            connection.getOutputStream().write(requestBody.getBytes("UTF-8"));

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Return the response as a string
                JSONObject obj = new JSONObject(response.toString());
                JSONArray exercises = obj.getJSONArray("exercises");
                JSONObject exercise = exercises.getJSONObject(0);
                double calories = exercise.getDouble("nf_calories");
                return calories;
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return null in case of an error
        return -1;
    }
    public static double fetchNutrient(String query){
        try {
            URL url = new URL(API_ENDPOINT_NUTRIENT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-app-id", "80e22ff8");
            connection.setRequestProperty("x-app-key", API_KEY);

            // Set input and output streams to true
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // Set the request body
            String requestBody = "{ \"query\": \"" + query + "\" }";
            connection.getOutputStream().write(requestBody.getBytes("UTF-8"));

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Return the response as a string
                JSONObject obj = new JSONObject(response.toString());
                JSONArray exercises = obj.getJSONArray("foods");
                JSONObject exercise = exercises.getJSONObject(0);
                double calories = exercise.getDouble("nf_calories");
                return calories;
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Return null in case of an error
        return -1;
    }

}
