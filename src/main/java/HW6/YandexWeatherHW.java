package HW6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class YandexWeatherHW {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "55.7522")
                .addQueryParameter("lon","37.6156")
                .addQueryParameter("lang", "ru_RU")
                .addQueryParameter("limit", "5")
                .addQueryParameter("hours", "false")
                .addQueryParameter("extra", "false")
                .build();

        Request request = new Request.Builder()
   //             .url("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true")
                .url(url)
                .addHeader("X-Yandex-API-Key", "5d2c0be3-1038-41fa-9a94-bacd276a84f7")
                .get()
//                .addHeader("accept", "aplication/json")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());


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
