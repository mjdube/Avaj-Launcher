package Transportation;

import The_Tower.Flyable;
import The_Tower.WeatherTower;

public class Baloon extends Aircraft  implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {
        if (weatherTower.getWeather(this.coordinates).equals("SUN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            System.out.println("Baloon it is sunny");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("RAIN")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() , this.coordinates.getHeight() - 5);
            System.out.println("Baloon it is raining");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("FOG")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            System.out.println("Baloon it is foggy");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("SNOW")){
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            System.out.println("Baloon it is snowing");
        }

        if (this.coordinates.getHeight() == 0){
            this.weatherTower.unregister(this);
            System.out.println("Baloon landing");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower.register(this);
        System.out.printf("The Tower says: Baloon #%s(%l) registered to the weather tower", this.name, this.getId());
    }
}
