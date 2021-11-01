package patterns.creational.abstract_factory;

import model.interfaces.Polinomable;

public interface RationalPolinomFactory {
    Polinomable getNumerator();
    Polinomable getDenumerator();
}
