package patterns.behavioral.template;

import model.Polinom;
import model.RationalPolinom;

public class Runner {
    public static void main(String[] args) {
        PolinomTemplate polinom = new Polinom();
        PolinomTemplate rationalPolinom = new RationalPolinom();

        polinom.showPolinomInfo();
        rationalPolinom.showPolinomInfo();
    }
}
