package avaj.tower;

import avaj.exceptions.AirCraftInfoException;
import avaj.exceptions.SimulationException;
import avaj.transportation.AircraftFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Simulator {
    public static void main(String args[]) {
        String fileName = args[0];
        String text = "";
        ArrayList<String> airCraft = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                try {
                    int number;
                    text = br.readLine();
                    number = Integer.parseInt(text);
                    if (1 > number || number > 2147483647) throw new SimulationException(number);
                } catch (SimulationException e) {
                    System.out.println(e.outOfRange());
                } catch (InputMismatchException e) {
                    System.out.println("Not a number!");
                }
                while ((text = br.readLine()) != null)
                    airCraft.add(text);
                for (int i = 0; i < airCraft.size(); i++) {
                    try {
                        String craftInfo[];
                        AircraftFactory aircraftFactory = new AircraftFactory();
                        WeatherTower weatherTower = new WeatherTower();
                        craftInfo = airCraft.get(i).split(" ");
                        if (craftInfo.length != 5 || Integer.parseInt(craftInfo[2]) < 0 || Integer.parseInt(craftInfo[3]) < 0)
                            throw new AirCraftInfoException();
                        Flyable flyable = aircraftFactory.newAircraft(craftInfo[0], craftInfo[1], Integer.parseInt(craftInfo[2]), Integer.parseInt(craftInfo[3]), Integer.parseInt(craftInfo[4]));
                        flyable.registerTower(weatherTower);
                    } catch (AirCraftInfoException e) {
                        System.out.println("Not enough information, please check type, name, coordinates and height...");
                    } catch (NullPointerException e){
                        System.out.println(e.toString());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }
}
