package pkt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgArayuzu implements ISubject{
    private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver o) {
        subscribers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        subscribers.remove(o);
    }

    @Override
    public void notify(int sicaklik) {
        for(IObserver subscriber: subscribers) {
            subscriber.update(sicaklik);
        }
    }

}
