package avaj.transportation;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight());
    }

    public long getId(){
        return nextId();
    }

    private long nextId(){
        id = idCounter++;
        return (id);
    }

}
