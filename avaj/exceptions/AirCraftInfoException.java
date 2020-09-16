package avaj.exceptions;

public class AirCraftInfoException extends Exception{
    public AirCraftInfoException(){}

    public String notEnoughInfo(){
        return "Not enough information, please check type, name, coordinates and height...";
    }
}
