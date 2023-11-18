package data_access;

import use_case.FoodAddDataAccessInterface;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FoodDataAccessObject implements FoodAddDataAccessInterface {
    private final String csvFilePath;
    private final String apiEndpoint = "https://trackapi.nutritionix.com/v2/natural/nutrients";
    private final String appId = "80e22ff8";
    private final String apiKey = "36950e27031466b64fcd4d0a977d6953";


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
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiEndpoint))
                    .header("Content-Type", "application/json")
                    .header("x-app-id", appId)
                    .header("x-app-key", apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "{\"query\":\"" + foodName + "\", \"quantity\":" + amount + "}")
                    )
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                Map<String, Object> parsedJson = parseJson(responseBody);
                float calories = (Float) parsedJson.get("calories");
                return Math.round(calories);
            } else {
                System.out.println("API require error " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Map<String, Object> parseJson(String json) {
        return new HashMap<>();
    }

}
