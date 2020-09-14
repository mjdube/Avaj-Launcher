package avaj.transportation;

import avaj.tower.Flyable;
import avaj.tower.SimulationFile;
import avaj.tower.WeatherTower;

public class Baloon extends Aircraft  implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    @Override
    public void updateCondition() {
        if (weatherTower.getWeather(this.coordinates).equals("SUN")){
            String msg = "Baloon #"+this.name + " ("+this.id+") " + ": Clear blue sky, and we going up!";
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println("Baloon it is sunny");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("RAIN")){
            String msg = "Baloon #"+this.name + " ("+this.id+") " + ": We going to get wet, let's go down";
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude() , this.coordinates.getHeight() - 5);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println("Baloon it is raining");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("FOG")){
            String msg = "Baloon #"+this.name + " ("+this.id+") " + ": We can't see nothing, watch out for any trees";
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println("Baloon it is foggy");
        }
        else if (weatherTower.getWeather(this.coordinates).equals("SNOW")){
            String msg = "Baloon #"+this.name + " ("+this.id+") " + ": Damn it's cold, why we even flying?";
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println("Baloon it is snowing");
        }

        if (this.coordinates.getHeight() == 0){
            String msg = "Baloon #"+this.name + " ("+this.id+") " + ": We are landing, going to the ground";
            this.weatherTower.unregister(this);
            SimulationFile.getSimulationFile().writeToFile(msg);
            System.out.println("Baloon landing");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        String msg = "The Tower says: Baloon #"+this.name+" ("+ this.id +") registered to the weather tower";
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        SimulationFile.getSimulationFile().writeToFile(msg);
        System.out.println(msg);
    }
}
