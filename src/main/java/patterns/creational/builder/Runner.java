package patterns.creational.builder;

import model.Polinom;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {

        Director director1 = new Director();
        director1.setBuilder(new FirstPolinomBuilder());
        Polinom polinom1 = director1.buildPolinom();
        Formalization.title("Creating first polinom");
        System.out.println(polinom1);

        Director director2 = new Director();
        director2.setBuilder(new SecondPolinomBuilder());
        Polinom polinom2 = director2.buildPolinom();
        Formalization.title("Creating second polinom");
        System.out.println(polinom2);
    }
}
