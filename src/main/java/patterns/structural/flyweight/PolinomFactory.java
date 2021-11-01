package patterns.structural.flyweight;

import model.Polinom;
import model.RationalPolinom;
import model.interfaces.Polinomable;
import printing.Formalization;

import java.util.HashMap;
import java.util.Map;

public class PolinomFactory {
    private static final Map<String, Polinomable> polinoms = new HashMap<>();

    public Polinomable getPolinomByType(String type){
        Polinomable polinom = polinoms.get(type);

        if(polinom == null){
            switch (type){
                case "simple polinom":
                    Formalization.title("Creating simple polinom");
                    polinom = new Polinom();
                    break;
                case "rational polinom":
                    Formalization.title("Creating rational polinom");
                    polinom = new RationalPolinom();
            }
            polinoms.put(type, polinom);
        }
        return polinom;
    }
}
