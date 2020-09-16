package avaj.tower;

import avaj.transportation.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static int i = 0;

    private WeatherProvider (){ }

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int selectWeather = rand.nextInt(4);
        return (weather[selectWeather]);
    }
}
