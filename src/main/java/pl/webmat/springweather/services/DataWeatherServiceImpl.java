package pl.webmat.springweather.services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.webmat.springweather.domain.Weather;

@Service
public class DataWeatherServiceImpl implements DataWeatherService {
    private final ConnectionService connectionService;

    public DataWeatherServiceImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public Weather getData() {
        String res = connectionService.connect();
        return new Gson().fromJson(res, Weather.class);
    }
}
