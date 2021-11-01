package patterns.structural.bridge;

import model.Polinom;
import model.RationalPolinom;

public class Runner {
    public static void main(String[] args) {
        Polinoms[] polinoms = {
                new PolinomCreation(new Polinom(1, 2)),
                new PolinomCreation(new Polinom(1, new double[]{2, 3, 4})),
                new RationalPolinomCreation(new RationalPolinom(1.0, 3,2)),
        };
        for(Polinoms polinom: polinoms){
            polinom.printPolinomInfo();
        }
    }
}
