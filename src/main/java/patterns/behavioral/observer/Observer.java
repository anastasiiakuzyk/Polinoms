package patterns.behavioral.observer;

import model.interfaces.Polinomable;

import java.util.List;

public interface Observer {
    public void handleEvent(List<Polinomable> polinoms);
}
