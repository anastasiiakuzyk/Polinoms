package patterns.creational.factory;

import model.interfaces.Polinomable;

public class Runner {
    public static void main(String[] args) {
//        Factory polinomFactory = createPolinomByType("simple polinom");
        Factory polinomFactory = createPolinomByType("rational polinom");
        Polinomable polinom = polinomFactory.createPolinom();
        polinom.getResult();
        System.out.println(polinom);
    }

    public static Factory createPolinomByType(String type) {
        if (type.equals("simple polinom")) {
            return new PolinomFactory();
        } else if(type.equals("rational polinom")){
            return new RationalPolinomFactory();
        } else {
            throw new RuntimeException(type + "is unknown");
        }
    }
}
