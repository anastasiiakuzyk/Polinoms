package patterns.behavioral.iterator;

import model.Polinom;

public class Runner {
    public static void main(String[] args) {
        double[] coefs = {1, 2, 3, 4};

        Polinom polinom = new Polinom(1, coefs);
        System.out.println(polinom);
        Iterator iterator = polinom.getIterator();
        System.out.println("X:" + polinom.getX());
        System.out.println("Coefs:");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString() + " ");
        }
    }

}
