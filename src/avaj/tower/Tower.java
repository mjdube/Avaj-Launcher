package avaj.tower;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List <Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> unobserved = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        if (observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public  void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionChanged(){
        /*
        for (Flyable flyable: observers){
            flyable.updateCondition();
            if (flyable.getCoordinates().getHeight() <= 0){
                unobserved.add(flyable);
            }
        }
        observers.removeAll(unobserved);*/
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateCondition();
        }
    }
}
