package The_Tower;

import Exceptions.AirCraftInfoException;
import Exceptions.SimulationException;
import Transportation.AircraftFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Simulator {
    public static void main(String args[]) {
        String fileName = args[0];
        String text = "";
        String craftInfo[];
        WeatherTower weatherTower = new WeatherTower();
        ArrayList<String> airCraft = new ArrayList<>();
        Flyable flyable = null;
        Tower tower = null;
        int number;

        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                try {
                    text = br.readLine();
                    number = Integer.parseInt(text);
                    if (1 <= number && number <= 2147483647) throw new SimulationException(number);
                } catch (SimulationException e) {
                    System.out.println(e.outOfRange());
                } catch (InputMismatchException e) {
                    System.out.println("Not a number!");
                }
                while ((text = br.readLine()) != null)
                    airCraft.add(text);
                for (int i = 0; i < airCraft.size(); i++) {
                    try {
                        craftInfo = airCraft.get(i).split(" ");
                        if (craftInfo.length != 5 || Integer.parseInt(craftInfo[2]) < 0 || Integer.parseInt(craftInfo[3]) < 0)
                            throw new AirCraftInfoException();
                        flyable = AircraftFactory.newAircraft(craftInfo[0], craftInfo[1], Integer.parseInt(craftInfo[2]), Integer.parseInt(craftInfo[3]), Integer.parseInt(craftInfo[4]));
                        flyable.registerTower(weatherTower);
                    } catch (AirCraftInfoException e) {
                        System.out.println("Not enough information, please check type, name, coordinates and height...");
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
