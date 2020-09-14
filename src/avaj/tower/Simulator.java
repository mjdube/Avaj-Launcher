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
        int number;
        ArrayList<String> airCraft = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();
        File file = new File(fileName);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            text = br.readLine();
            number = Integer.parseInt(text);
            if (1 > number || number > 2147483647) throw new SimulationException(number);
            while ((text = br.readLine()) != null) {
                airCraft.add(text);
            }
            for (int i = 0; i < airCraft.size(); i++) {
                String craftInfo[];
                AircraftFactory aircraftFactory = new AircraftFactory();
                craftInfo = airCraft.get(i).split(" ");
                if (craftInfo.length != 5 || Integer.parseInt(craftInfo[2]) < 0 || Integer.parseInt(craftInfo[3]) < 0)
                    throw new AirCraftInfoException();
                aircraftFactory.newAircraft(craftInfo[0], craftInfo[1], Integer.parseInt(craftInfo[2]), Integer.parseInt(craftInfo[3]), Integer.parseInt(craftInfo[4])).registerTower(weatherTower);
            }
            while (number > 0) {
                weatherTower.changeWeather();
                number--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AirCraftInfoException e) {
            System.out.println("Not enough information, please check type, name, coordinates and height...");
        } catch (NullPointerException e) {
            System.out.println("unable to register an unknown transportation");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SimulationException e) {
            System.out.println(e.outOfRange());
        } catch (InputMismatchException e) {
            System.out.println("Unknown aircraft");
        } finally {
            SimulationFile.getSimulationFile().closeFile();
        }
        System.out.println("Finish");
    }
}
