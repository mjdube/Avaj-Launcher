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
        if (weatherTower.getWeather(this.coordinates).equals("SUN")){
            String msg = "Jetplane #"+this.name + " ("+this.id+") " + ": Can't you see the private jet flying over you?";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        }
        else if (weatherTower.getWeather(this.coordinates).equals("RAIN")){
            String msg = "Jetplane #"+this.name + " ("+this.id+") " + ": Let's move quicky, hailstorm may hit us";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,this.coordinates.getLatitude() , this.coordinates.getHeight());
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        }
        else if (weatherTower.getWeather(this.coordinates).equals("FOG")){
            String msg = "Jetplane #"+this.name + " ("+this.id+") " + ": Watch out for other planes!";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        }
        else if (weatherTower.getWeather(this.coordinates).equals("SNOW")){
            String msg = "Jetplane #"+this.name + " ("+this.id+") " + ": We taking a risk flying in snow";
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println(msg);
        }

        if (this.coordinates.getHeight() == 0){
            String msg1 = "Jetplane #"+this.name + " ("+this.id+") " + ": We are landing ladies and gentlemen, hope you enjoyed the ride.";
            weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg1);
            System.out.println(msg1);
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
