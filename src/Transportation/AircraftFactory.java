package Transportation;

import The_Tower.Flyable;

public class AircraftFactory {

    public static Flyable newAircraft (String type, String name, int longitude, int latitude, int height){
        if (type.equalsIgnoreCase("Baloon")){
            Baloon baloon = new Baloon(name, new Coordinates(longitude,latitude, height));
            return baloon;
        }
        else if (type.equalsIgnoreCase("Jetplane")){
            Jetplane jetplane = new Jetplane(name, new Coordinates(longitude, latitude, height));
            return jetplane;
        }
        else if (type.equalsIgnoreCase("Helicoper")){
            Helicopter helicopter = new Helicopter(name, new Coordinates(longitude, latitude, height));
            return helicopter;
        }
        else
            return null;
    }
}
