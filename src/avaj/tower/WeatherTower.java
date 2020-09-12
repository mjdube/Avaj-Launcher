package avaj.tower;

import avaj.transportation.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }
}
