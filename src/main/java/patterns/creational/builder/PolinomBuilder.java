package patterns.creational.builder;

import model.Polinom;

public abstract class PolinomBuilder {
    Polinom polinom;

    void createPolinom() {
        polinom = new Polinom();
    }

    abstract void buildX();

    abstract void buildDegree();

    abstract void buildCoefsArray();

    Polinom getPolinom() {
        return polinom;
    }
}
