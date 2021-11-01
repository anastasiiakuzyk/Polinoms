package patterns.behavioral.observer;

import model.interfaces.Polinomable;

import java.util.ArrayList;
import java.util.List;

public class PolinomShare implements Observed {
    List<Polinomable> polinoms = new ArrayList<>();

    List<Observer> subscribers = new ArrayList<>();

    public void addPolinom(Polinomable polinom){
        polinoms.add(polinom);
        notifyObservers();
    }

    public void removePolinom(Polinomable polinom){
        this.polinoms.remove(polinom);
        notifyObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: subscribers){
            observer.handleEvent(this.polinoms);
        }
    }
}
