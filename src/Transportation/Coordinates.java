package Transportation;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude()
    {
        if (this.longitude < 0)
            return (-1);
        else
            return (this.longitude);
    }

    public int getLatitude()
    {
        if (this.latitude < 0)
            return (-1);
        else
            return (this.latitude);
    }

    public int getHeight() {
        if ((1 <= this.height) && (this.height <= 100))
            return (this.height);
        else if (this.height > 100)
            return (100);
        else
            return (0);
    }
}
