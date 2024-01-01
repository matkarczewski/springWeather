package pl.webmat.springweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.webmat.springweather.domain.Weather;
import pl.webmat.springweather.services.DataWeatherService;

@Controller
public class WeatherController {
    private final DataWeatherService dataWeatherService;

    public WeatherController(DataWeatherService dataWeatherService) {
        this.dataWeatherService = dataWeatherService;
    }

    @RequestMapping({"/pogoda", "/", ""})
    public String showWeather(Model model) {
        Weather weather = dataWeatherService.getData();
        model.addAttribute("weather", weather);
        return "pogoda";
    }

    @RequestMapping("/pogoda/charts")
    public String showCharts(Model model) {
        Weather weather = dataWeatherService.getData();
        model.addAttribute("weather", weather);
        return "pogoda/charts";
    }

}
