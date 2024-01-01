package pl.webmat.springweather.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.webmat.springweather.services.DataWeatherService;

@Component
public class BootStarter implements CommandLineRunner {
    private final DataWeatherService dataWeatherService;

    public BootStarter(DataWeatherService dataWeatherService) {
        this.dataWeatherService = dataWeatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        dataWeatherService.getData();
    }
}
