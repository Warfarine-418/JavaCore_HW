package HW6;

import HW6.entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static HW6.Period.FIVE_DAYS;
import static HW6.Period.NOW;

public class YandexWeatherHW {
    private static final String PROTOCOl = "https";
    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String FORECAST = "forecast";
    private static final String VERSION = "v2";
    private static final String LATITUDE = "lat";
    private static final String LATITUDE_VALUE = "55.7522";
    private static final String LONGITUDE = "lon";
    private static final String LONGITUDE_VALUE = "37.6156";
    private static final String LANGUAGE = "lang";
    private static final String LANGUAGE_VALUE = "ru_RU";
    private static final String LIMIT_DAYS = "limit";
    private static final String LIMIT_1_DAYS_VALUE = "1";
    private static final String LIMIT_5_DAYS_VALUE = "5";
    private static final String HOURS = "hours";
    private static final String EXTRA = "extra";
    private static final String FALSE_VALUE = "false";
    private static final String API_KEY = "X-Yandex-API-Key";
    private static final String API_KEY_VALUE = "5d2c0be3-1038-41fa-9a94-bacd276a84f7";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period) throws IOException, SQLException {
        switch (period) {
            case NOW:
                HttpUrl urlOne = new HttpUrl.Builder()
                        .scheme(PROTOCOl)
                        .host(BASE_HOST)
                        .addPathSegment(VERSION)
                        .addPathSegment(FORECAST)
                        .addQueryParameter(LATITUDE, LATITUDE_VALUE)
                        .addQueryParameter(LONGITUDE, LONGITUDE_VALUE)
                        .addQueryParameter(LANGUAGE, LANGUAGE_VALUE)
                        .addQueryParameter(LIMIT_DAYS, LIMIT_1_DAYS_VALUE)
                        .addQueryParameter(HOURS, FALSE_VALUE)
                        .addQueryParameter(EXTRA, FALSE_VALUE)
                        .build();

                Request request = new Request.Builder()
                        .url(urlOne)
                        .addHeader(API_KEY, API_KEY_VALUE)
                        .build();

                Response oneDayWeatherResponse = okHttpClient.newCall(request).execute();
                String responseStringOneDay = oneDayWeatherResponse.body().string();

                String locationNow = objectMapper.readTree(responseStringOneDay).at("/geo_object/locality/name").asText();
                String temperatureNow = objectMapper.readTree(responseStringOneDay).at("/fact/temp").asText();
                String conditionNow = objectMapper.readTree(responseStringOneDay).at("/fact/condition").asText();
                Double tempNowDouble = Double.parseDouble(temperatureNow);

                System.out.println("Город: " + locationNow);
                System.out.println("Температура сейчас: " + tempNowDouble + " С");
                System.out.println("Состояние: " + conditionNow);
                DataBaseRepository dataBaseRepository = new DataBaseRepository();
                List<Weather> weatherListNow = new ArrayList<Weather>();

                weatherListNow.add(new Weather(locationNow, "Now", tempNowDouble, conditionNow));
                dataBaseRepository.saveWeatherToDataBase(weatherListNow);


                break;


            case FIVE_DAYS:
                HttpUrl urlFive = new HttpUrl.Builder()
                        .scheme(PROTOCOl)
                        .host(BASE_HOST)
                        .addPathSegment(VERSION)
                        .addPathSegment(FORECAST)
                        .addQueryParameter(LATITUDE, LATITUDE_VALUE)
                        .addQueryParameter(LONGITUDE, LONGITUDE_VALUE)
                        .addQueryParameter(LANGUAGE, LANGUAGE_VALUE)
                        .addQueryParameter(LIMIT_DAYS, LIMIT_5_DAYS_VALUE)
                        .addQueryParameter(HOURS, FALSE_VALUE)
                        .addQueryParameter(EXTRA, FALSE_VALUE)
                        .build();

                Request requestFive = new Request.Builder()
                        .url(urlFive)
                        .addHeader(API_KEY, API_KEY_VALUE)
                        .build();

                Response fiveDayWeatherResponse = okHttpClient.newCall(requestFive).execute();
                String responseStringFiveDay = fiveDayWeatherResponse.body().string();

                String locationFive = objectMapper.readTree(responseStringFiveDay).at("/geo_object/locality/name").asText();
//                String temperatureFive = objectMapper.readTree(responseStringFiveDay).at("/fact/temp").asText();
//                String conditionFive = objectMapper.readTree(responseStringFiveDay).at("/fact/condition").asText();

                String dateFirstDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(0).at("/date").asText();
                String temperatureFirstDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(0).at("/parts/day/temp_avg").asText();
                String conditionFirstDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(0).at("/parts/day/condition").asText();
                Double tempFirstDouble = Double.parseDouble(temperatureFirstDay);

                String dateSecondDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(1).at("/date").asText();
                String temperatureSecondDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(1).at("/parts/day/temp_avg").asText();
                String conditionSecondDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(1).at("/parts/day/condition").asText();
                Double tempSecondDouble = Double.parseDouble(temperatureSecondDay);

                String dateThirdDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(2).at("/date").asText();
                String temperatureThirdDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(2).at("/parts/day/temp_avg").asText();
                String conditionThirdDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(2).at("/parts/day/condition").asText();
                Double tempThirdDouble = Double.parseDouble(temperatureThirdDay);

                String dateFourthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(3).at("/date").asText();
                String temperatureFourthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(3).at("/parts/day/temp_avg").asText();
                String conditionFourthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(3).at("/parts/day/condition").asText();
                Double tempFourthDouble = Double.parseDouble(temperatureFourthDay);

                String dateFifthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(4).at("/date").asText();
                String temperatureFifthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(4).at("/parts/day/temp_avg").asText();
                String conditionFifthDay = objectMapper.readTree(responseStringFiveDay).at("/forecasts").get(4).at("/parts/day/condition").asText();
                Double tempFifthDouble = Double.parseDouble(temperatureFifthDay);

//                System.out.println("Сейчас");
//                System.out.println("Город: " + locationFive);
//                System.out.println("Температура сейчас: " + temperatureFive + " градуса");
//                System.out.println("Состояние: " + conditionFive);
//                System.out.println("----------");
//                System.out.println("Дата :  Температура");
//                System.out.println(dateFirstDay + " : " + temperatureFirstDay);
//                System.out.println(dateSecondDay + " : " + temperatureSecondDay);
//                System.out.println(dateThirdDay + " : " + temperatureThirdDay);
//                System.out.println(dateFourthDay + " : " + temperatureFourthDay);
//                System.out.println(dateFifthDay + " : " + temperatureFifthDay);

                DataBaseRepository dataBaseRepositoryFive = new DataBaseRepository();
                List<Weather> weatherListFive = new ArrayList<Weather>();

                weatherListFive.add(new Weather(locationFive, dateFirstDay, tempFirstDouble, conditionFirstDay));
                weatherListFive.add(new Weather(locationFive, dateSecondDay, tempSecondDouble, conditionSecondDay));
                weatherListFive.add(new Weather(locationFive, dateThirdDay, tempThirdDouble, conditionThirdDay));
                weatherListFive.add(new Weather(locationFive, dateFourthDay, tempFourthDouble, conditionFourthDay));
                weatherListFive.add(new Weather(locationFive, dateFifthDay, tempFifthDouble, conditionFifthDay));
                dataBaseRepositoryFive.saveWeatherToDataBase(weatherListFive);
                for (Weather weather:weatherListFive) {
                    System.out.println(weather);
                }
                //System.out.println(dataBaseRepositoryFive.getSavedToDBWeather());
                break;
        }

    }

}

// Москва = 55.7522, 37.6156. (ш и д)


//    С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
//    пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)

//        Подобрать источник самостоятельно. Можно использовать api accuweather,
//        порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа,
//        найдите нужный endpoint и изучите документацию.
//        Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
//        (этого достаточно для выполнения д/з).


//        Второй вариант выполнения ДЗ - доработать свою программу, выводящую погоду, из 6 урока так,
//        чтобы в консоль выводилась информация в читабельном формате на ваше усмотрение -
//        например "Сегодня в Ростове 5 градусов тепла". Главное - распарсить json ответ,
//        достать оттуда нужные данные.

