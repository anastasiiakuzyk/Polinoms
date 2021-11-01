package patterns.creational.singleton;

import model.Polinom;
import model.RationalPolinom;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {
        Polinom polinom1 = new Polinom();
        System.out.println(polinom1);
        PolinomsSum.getPolinomsSum().addPolinomResult(polinom1);
        RationalPolinom polinom2 = new RationalPolinom();
        System.out.println(polinom2);
        PolinomsSum.getPolinomsSum().addPolinomResult(polinom2);
        Polinom polinom3 = new Polinom();
        System.out.println(polinom3);
        PolinomsSum.getPolinomsSum().addPolinomResult(polinom3);

        Formalization.title("Result of adding few results");
        System.out.println(Formalization.result(PolinomsSum.getPolinomsSum().getSum()));
    }
}
