package Transportation;

import The_Tower.Flyable;
import The_Tower.WeatherProvider;
import The_Tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {
        if (weatherTower.getWeather(this.coordinates).equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            System.out.println("helicopter is sunny");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("RAIN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,this.coordinates.getLatitude() , this.coordinates.getHeight());
            System.out.println("helicopter it is raining");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            System.out.println("helicopter it is foggy");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("SNOW")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            System.out.println("helicopter it is snowing");
        }
        else if (this.coordinates.getHeight() == 0){
            weatherTower.unregister(this);
            System.out.println("helicopter landing");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.printf("The Tower says: Helicopter #%s(%l) registered to the weather tower", this.name, this.getId());
    }
}
