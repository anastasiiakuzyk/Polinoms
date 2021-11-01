package patterns.creational.abstract_factory;

import model.RationalPolinom;
import model.interfaces.Polinomable;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {
        SomeRationalPolinomFactory rationalPolinomFactory = new SomeRationalPolinomFactory();
        Polinomable numerator = rationalPolinomFactory.getNumerator();
        Polinomable denumerator = rationalPolinomFactory.getDenumerator();

        Formalization.title("Creating rational polinom");
        System.out.println(new RationalPolinom(numerator, denumerator));
    }
}
