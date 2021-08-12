package HW6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private YandexWeatherHW weatherHW = new YandexWeatherHW();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput) throws IOException, SQLException {
        Integer userIntegerInput = Integer.parseInt(userInput);
        switch (variants.get(userIntegerInput)) {
            case NOW:
                weatherHW.getWeather(Period.NOW);
                break;
            case FIVE_DAYS:
                weatherHW.getWeather(Period.FIVE_DAYS);
                break;
        }
    }
}
