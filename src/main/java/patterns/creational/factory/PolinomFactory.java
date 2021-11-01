package patterns.creational.factory;

import model.Polinom;
import model.interfaces.Polinomable;

public class PolinomFactory implements Factory{
    @Override
    public Polinomable createPolinom() {
        return new Polinom();
    }
}
