package avaj.transportation;

import avaj.tower.Flyable;
import avaj.tower.SimulationFile;

import avaj.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private boolean registered = true;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {

//        System.out.println("heli height " + this.coordinates.getHeight());
//        System.out.println(weatherTower.getWeather(this.coordinates));
        String weather = weatherTower.getWeather(this.coordinates);

        if (this.coordinates.getHeight() > 0) {
            if (weather.equals("SUN")) {
                String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": We are out of here, let's go!";
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("RAIN")) {
                String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": Close all the windows, we might get wet";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("FOG")) {
                String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": Watch out for the birds, those are beautiful creatures";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weather.equals("SNOW")) {
                String msg = "Helicopter #" + this.name + " (" + this.id + ") " + ": We should stop flying, it's too risky";
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            }
        } else if (this.coordinates.getHeight() <= 0 && registered == true){
            String msg1 = "Helicopter #" + this.name + " (" + this.id + ") " + ": We are landing ladies and gentlemen, hope you enjoyed the ride.";
            String msg2 = "Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.";

            SimulationFile.getSimulationFile().writeToFile(msg1);
//            weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg2);
            registered = false;
            System.out.println(msg1);
            System.out.println(msg2);
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
