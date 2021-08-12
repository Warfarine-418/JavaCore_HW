package HW6.entity;

public class Weather {
    private String city;
    private String localDate;
    private Double temperature;
    private String condition;

    public Weather(String city, String localDate, Double temperature, String condition) {
        this.city = city;
        this.localDate = localDate;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", temperature=" + temperature +
                ", condition='" + condition + '\'' +
                '}';
    }
}
