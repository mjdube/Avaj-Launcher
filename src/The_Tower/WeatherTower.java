package The_Tower;

import Transportation.Coordinates;

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider;

    public String getWeather(Coordinates coordinates){
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
