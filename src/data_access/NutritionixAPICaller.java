package data_access;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NutritionixAPICaller {
    private static final String API_ENDPOINT = "https://trackapi.nutritionix.com/v2/natural/exercise";
    private static final String API_KEY = "36950e27031466b64fcd4d0a977d6953";

    public static void main(String[] args) {
        try {
            URL url = new URL(API_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-app-id", "80e22ff8");
            connection.setRequestProperty("x-app-key", API_KEY);

            // 设置输入输出流为true，以便我们可以写入请求正文
            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 这里只是一个示例，您可能需要以某种方式动态生成或获取此数据
            String requestBody = "{ \"query\": \"ran 3 miles\" }";
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

                // 打印结果
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
