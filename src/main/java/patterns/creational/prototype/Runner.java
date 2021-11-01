package patterns.creational.prototype;

import model.Polinom;
import printing.Formalization;

public class Runner {
    public static void main(String[] args) {
        Polinom polinom = new Polinom();
        Formalization.title("Creating polinom");
        System.out.println(polinom);

        PolinomFactory factory = new PolinomFactory(polinom);
        Polinom polinomClone = factory.clonePolinom();
        Formalization.title("Cloning polinom");
        System.out.println(polinomClone);
    }
}
