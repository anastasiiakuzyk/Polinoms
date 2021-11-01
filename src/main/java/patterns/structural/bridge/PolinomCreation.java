package patterns.structural.bridge;

import model.interfaces.Polinomable;
import printing.Formalization;

public class PolinomCreation extends Polinoms{
    protected PolinomCreation(Polinomable polinom) {
        super(polinom);
    }

    @Override
    public void printPolinomInfo() {
        Formalization.title("Printing polinom info");
        System.out.println(polinom);
    }
}
