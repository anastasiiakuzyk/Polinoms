package patterns.creational.factory;

import model.RationalPolinom;
import model.interfaces.Polinomable;

public class RationalPolinomFactory implements Factory{

    @Override
    public Polinomable createPolinom() {
        return new RationalPolinom();
    }
}
