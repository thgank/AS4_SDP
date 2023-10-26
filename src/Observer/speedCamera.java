package Observer;

import java.util.ArrayList;
import java.util.List;

public class speedCamera implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void detectSpeedingVehicle() {
        System.out.println("Speed camera detected a speeding vehicle.");
        notifyObservers("Speeding Vehicle Detected");
    }
}
