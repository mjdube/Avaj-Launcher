package avaj.exceptions;

public class ScenarioException extends Exception {

    public ScenarioException(){ }
    public String tooManyFiles(){
        return "Too many file found, only one file please";
    }

}