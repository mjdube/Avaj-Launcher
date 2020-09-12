package avaj.tower;

import avaj.transportation.Coordinates;

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider;

    public String getWeather(Coordinates coordinates){
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
