package HW6;

import HW6.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (city, localDate, temperature, condition) " +
            "values (?,?,?,?)";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.setString(4, weather.getCondition());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getString("localDate"),
                        resultSet.getString("city"),
                        resultSet.getDouble("temperature"),
                        resultSet.getString("condition")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherList;
    }


}
