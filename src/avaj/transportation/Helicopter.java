package avaj.transportation;

import avaj.tower.Flyable;
import avaj.tower.SimulationFile;
import avaj.tower.SimulationFile;
import avaj.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {
        if (weatherTower.getWeather(this.coordinates).equals("SUN")) {
            String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": We are out of here, let's go!";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        } else if (weatherTower.getWeather(this.coordinates).equals("RAIN")) {
            String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": Close all the windows, we might get wet";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        } else if (weatherTower.getWeather(this.coordinates).equals("FOG")) {
            String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": Watch out for the birds, those are beautiful creatures";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        } else if (weatherTower.getWeather(this.coordinates).equals("SNOW")) {
            String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": We should stop flying, it's too risky";
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        }

        if (this.coordinates.getHeight() == 0) {
            String msg1 = "Jetplane #" + this.name + " (" + this.id + ") " + ": We are landing ladies and gentlemen, hope you enjoyed the ride.";
            String msg2 = "Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.";
            weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg1);
            System.out.println(msg1);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        String msg = "The Tower says: Helicopter #" + this.name + " (" + this.id + ") registered to the weather tower";
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        SimulationFile.getSimulationFile().writeToFile(msg);
        System.out.println(msg);
    }
}
