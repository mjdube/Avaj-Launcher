package avaj.tower;

import avaj.exceptions.AirCraftInfoException;
import avaj.exceptions.SimulationException;
import avaj.transportation.AircraftFactory;
import avaj.exceptions.ScenarioException;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Simulator {
    public static void main(String args[]) {
        String text = "";
        int number;
        ArrayList<String> airCraft = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();

        try {
            if (args.length > 1) throw new ScenarioException();
            String fileName = args[0];
            File file = new File(fileName);
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
            for (int i = 0; i < number; i++)
                    weatherTower.changeWeather();
        } catch (FileNotFoundException e) {
            System.out.println("No file found... ");
        } catch (AirCraftInfoException e) {
            System.out.println("Not enough information, please check type, name, coordinates and height... ");
        } catch (NullPointerException e) {
            System.out.println("Unable to register an unknown transportation and continue with Avaj... ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SimulationException e) {
            System.out.println(e.outOfRange());
        } catch (InputMismatchException e) {
            System.out.println("Unknown aircraft inserted... ");
        } catch (NumberFormatException e){
            System.out.println("Please enter a number...");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please check/insert your file... ");
        } catch (ScenarioException e){
            System.out.println(e.tooManyFiles());
        } finally {
            SimulationFile.getSimulationFile().closeFile();
        }
        System.out.println("Finish");
    }
}
