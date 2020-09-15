package avaj.tower;

import avaj.transportation.Coordinates;

public interface Flyable {
    public void updateCondition();
    public void registerTower(WeatherTower weatherTower);
    public Coordinates getCoordinates();
}
