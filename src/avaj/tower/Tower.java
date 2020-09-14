package avaj.tower;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List <Flyable> observers = new ArrayList<Flyable>();

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
