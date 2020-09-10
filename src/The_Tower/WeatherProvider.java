package The_Tower;

import Transportation.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvider;
    private static int i = 0;

    public WeatherProvider (){
        this.weatherProvider = new WeatherProvider();
    }

    public static WeatherProvider getWeatherProvider(){
        return weatherProvider = new WeatherProvider();
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int selectWeather = rand.nextInt(4);
        return (weather[selectWeather]);
    }
}
