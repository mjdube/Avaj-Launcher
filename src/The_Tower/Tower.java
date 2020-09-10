package The_Tower;

import Transportation.AircraftFactory;

import java.util.ArrayList;

public class Tower {
    private ArrayList <Flyable> observers;

    public void register(Flyable flyable){
        if (observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public  void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionChanged(){
        int i = 0;

        while (i < observers.size())
        {
            observers.get(i).updateCondition();
            i++;
        }
    }
}
