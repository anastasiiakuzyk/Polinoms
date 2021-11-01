package patterns.creational.abstract_factory;

import model.Polinom;
import model.interfaces.Polinomable;

public class SomeRationalPolinomFactory implements RationalPolinomFactory{

    @Override
    public Polinomable getNumerator() {
        return new Polinom();
    }

    @Override
    public Polinomable getDenumerator() {
        return new Polinom();
    }
}
