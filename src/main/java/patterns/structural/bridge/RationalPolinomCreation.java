package patterns.structural.bridge;

import model.interfaces.Polinomable;
import printing.Formalization;

public class RationalPolinomCreation extends Polinoms{

    protected RationalPolinomCreation(Polinomable polinom) {
        super(polinom);
    }

    @Override
    public void printPolinomInfo() {
        Formalization.title("Printing rational polinom info");
        System.out.println(polinom);
    }
}
