package avaj.tower;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationFile {
    private static SimulationFile simulationFile = null;
    private static BufferedWriter bw = null;
    private static File file = null;
    private static FileWriter fw = null;

    public SimulationFile() {
    }

    public static SimulationFile getSimulationFile() {
        if (simulationFile == null) {
            try {
                simulationFile = new SimulationFile();
                file = new File("Simulate.txt");
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
            } catch (IOException e) {

            }
        }
        return simulationFile;
    }

    public void writeToFile(String msg) {
        try {
            bw.write(msg);
            bw.newLine();
        } catch (IOException e) {
            System.out.println();
        }
    }

    public void closeFile() {
        try {
            if (bw != null)
                bw.close();
        } catch (IOException e) {

        }
    }
}
