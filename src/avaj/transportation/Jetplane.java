package avaj.transportation;

import avaj.tower.Flyable;
import avaj.tower.SimulationFile;
import avaj.tower.SimulationFile;
import avaj.tower.WeatherTower;

public class Jetplane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Jetplane(String name, Coordinates coordinates){
        super(name, coordinates);
    }


    @Override
    public void updateCondition() {
        if (this.coordinates.getHeight() > 0) {
            if (weatherTower.getWeather(this.coordinates).equals("SUN")) {
                String msg = "Jetplane #" + this.name + " (" + this.id + ") " + ": Can't you see the private jet flying over you?";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weatherTower.getWeather(this.coordinates).equals("RAIN")) {
                String msg = "Jetplane #" + this.name + " (" + this.id + ") " + ": Let's move quicky, hailstorm may hit us";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weatherTower.getWeather(this.coordinates).equals("FOG")) {
                String msg = "Jetplane #" + this.name + " (" + this.id + ") " + ": Watch out for other planes!";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            } else if (weatherTower.getWeather(this.coordinates).equals("SNOW")) {
                String msg = "Jetplane #" + this.name + " (" + this.id + ") " + ": We taking a risk flying in snow";
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                SimulationFile.getSimulationFile().writeToFile(msg);
                System.out.println(msg);
            }
        } else if (this.coordinates.getHeight() <= 0){
            String msg1 = "Jetplane #"+this.name + " ("+this.id+") " + ": We are landing ladies and gentlemen, hope you enjoyed the ride.";
            String msg2 = "Tower says: Jetplane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.";
            weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg1);
            SimulationFile.getSimulationFile().writeToFile(msg2);
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        String msg = "The Tower says: Jetplane #"+this.name+" ("+ this.id +") registered to the weather tower";
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        SimulationFile.getSimulationFile().writeToFile(msg);
        System.out.println(msg);
    }
}
