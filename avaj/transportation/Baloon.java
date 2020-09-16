package avaj.transportation;

import avaj.tower.Flyable;
import avaj.tower.SimulationFile;
import avaj.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {

//        System.out.println("baloon height " + this.coordinates.getHeight());
//        System.out.println(weatherTower.getWeather(this.coordinates));
        String weather = weatherTower.getWeather(this.coordinates);
        if (this.coordinates.getHeight() > 0) {
            if (weather.equals("SUN")) {
                String msg = "Baloon #" + this.name + " (" + this.id + ") " + ": Clear blue sky, and we going up!";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("RAIN")) {
                String msg = "Baloon #" + this.name + " (" + this.id + ") " + ": We going to get wet, let's go down";
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("FOG")) {
                String msg = "Baloon #" + this.name + " (" + this.id + ") " + ": We can't see nothing, watch out for any trees";
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("SNOW")) {
                String msg = "Baloon #" + this.name + " (" + this.id + ") " + ": Damn it's cold, why we even flying?";
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            }
        } else if (this.coordinates.getHeight() <= 0) {
            String msg1 = "Baloon #" + this.name + " (" + this.id + ") " + ": We are landing, going to the ground";
            String msg2 = "Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.";

            SimulationFile.getSimulationFile().writeToFile(msg1);
            weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg2);
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        String msg = "The Tower says: Baloon #" + this.name + " (" + this.id + ") registered to the weather tower";
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        SimulationFile.getSimulationFile().writeToFile(msg);
        System.out.println(msg);
    }
}
