package patterns.structural.flyweight;

import model.interfaces.Polinomable;

import java.util.ArrayList;
import java.util.List;

public class Runner  {

    public static void main(String[] args) {
        PolinomFactory polinomFactory = new PolinomFactory();
        List<Polinomable> polinoms = new ArrayList<>();

        polinoms.add(polinomFactory.getPolinomByType("simple polinom"));
        polinoms.add(polinomFactory.getPolinomByType("simple polinom"));
        polinoms.add(polinomFactory.getPolinomByType("simple polinom"));
        polinoms.add(polinomFactory.getPolinomByType("simple polinom"));

        polinoms.add(polinomFactory.getPolinomByType("rational polinom"));
        polinoms.add(polinomFactory.getPolinomByType("rational polinom"));
        polinoms.add(polinomFactory.getPolinomByType("rational polinom"));
        polinoms.add(polinomFactory.getPolinomByType("rational polinom"));

        polinoms.forEach(System.out::println);

    }
}


