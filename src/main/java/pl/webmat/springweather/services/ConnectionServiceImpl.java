package pl.webmat.springweather.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Value("${city}")
    private String city;

    @Value("${days}")
    private String days;

    @Value("${apiKey}")
    private String apiKey;

    @Override
    public String connect() {
        String result = null;

        try {
            URL url = new URL("https://api.weatherapi.com/v1/forecast.json?key=" + apiKey + "&q=" + city
                    + "&days=" + days + "&aqi=no&alerts=no");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            StringBuilder sb = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            result = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
