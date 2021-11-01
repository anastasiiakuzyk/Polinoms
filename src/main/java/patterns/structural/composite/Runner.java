package patterns.structural.composite;

import model.Polinom;
import model.RationalPolinom;
import model.interfaces.Polinomable;

public class Runner {
    public static void main(String[] args) {
        Group group = new Group();
        Polinomable polinom1 = new Polinom(2);
        Polinomable polinom2 = new Polinom(4, 5);
        Polinomable polinom3 = new RationalPolinom(4, 5, 6);

        group.addPolinom(polinom1);
        group.addPolinom(polinom2);
        group.addPolinom(polinom3);
        group.createCombination();

        group.removePolinom(polinom1);
        group.createCombination();
    }
}
