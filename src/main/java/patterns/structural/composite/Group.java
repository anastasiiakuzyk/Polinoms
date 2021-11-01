package patterns.structural.composite;

import model.Polinom;
import model.interfaces.Polinomable;
import printing.Formalization;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Polinomable> polinoms = new ArrayList<>();

    public void addPolinom(Polinomable polinom) {
        polinoms.add(polinom);
    }

    public void removePolinom(Polinomable polinom) {
        polinoms.remove(polinom);
    }

    public void createCombination() {
        Formalization.title("Combination of polinoms");
        for (Polinomable polinom : polinoms) {
            System.out.println(polinom);
        }
    }

}
