package avaj.exceptions;

public class SimulationException extends Exception {
    private final int simulation;
    public SimulationException(int simulation){
        this.simulation = simulation;
    }

    public String outOfRange(){
        return "Out of Range " + simulation;
    }

}
