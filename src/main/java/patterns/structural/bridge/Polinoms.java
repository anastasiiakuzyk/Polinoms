package patterns.structural.bridge;

import model.interfaces.Polinomable;

public abstract class Polinoms {
    protected Polinomable polinom;

    protected Polinoms(Polinomable polinom) {
        this.polinom = polinom;
    }

    public abstract void printPolinomInfo();
}
