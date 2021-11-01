package patterns.structural.decorator;

import model.Polinom;

public class Runner {
    public static void main(String[] args) {
        PolinomResult polinom = new SimplePolinom(new Polinom(3,7));
        System.out.println(polinom.getSpecialInfo());
    }
}
