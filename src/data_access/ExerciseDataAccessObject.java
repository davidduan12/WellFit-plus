package data_access;

import use_case.ExerciseAddDataAccessInterface;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
public class ExerciseDataAccessObject implements ExerciseAddDataAccessInterface {
    private final String csvFilePath;

    private final String apiEndpoint = "https://trackapi.nutritionix.com/v2/exercise";
    private final String appId = "80e22ff8";
    private final String apiKey = "36950e27031466b64fcd4d0a977d6953";

    public ExerciseDataAccessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public boolean existByName(String exerciseName) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
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
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiEndpoint))
                    .header("Content-Type", "application/json")
                    .header("x-app-id", appId)
                    .header("x-app-key", apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "{\"query\":\"" + exerciseName + "\", \"duration_min\":" + amount + "}")
                    )
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                // 这里需要根据 Nutritionix API 的响应格式来解析 JSON
                Map<String, Object> parsedJson = parseJson(responseBody);

                // 假设已正确解析热量
                float calories = (Float) parsedJson.get("calories");
                return Math.round(calories);
            } else {
                // 处理错误响应
                System.out.println("API require error " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 简化的 JSON 解析方法，需要根据您的具体响应结构进行调整
    private Map<String, Object> parseJson(String json) {
        // 这里可以使用 java.util 或其他方式解析 JSON
        // 返回一个包含解析后数据的 Map
        return new HashMap<>();
    }
}

