package patterns.structural.facade;

import model.Polinom;
import model.RationalPolinom;
import printing.Formalization;

public class Facade {
    Polinom denumerator = new Polinom(1,2);
    Polinom numerator = new Polinom(1,3);
    RationalPolinom rationalPolinom = new RationalPolinom(numerator, denumerator);

    public void printResultOfRationalPolinom(){
        Formalization.title("Result of rational polinom");
        System.out.println(rationalPolinom);
    }
}
