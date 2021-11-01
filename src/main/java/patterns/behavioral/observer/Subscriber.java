package patterns.behavioral.observer;

import model.interfaces.Polinomable;

import java.util.List;

public class Subscriber implements Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<Polinomable> polinoms) {
        System.out.println("Dear " + name + ",\nWe have changes:");
        polinoms.forEach(System.out::println);
        System.out.println();
    }
}
