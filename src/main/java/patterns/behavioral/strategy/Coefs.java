package patterns.behavioral.strategy;

import model.Polinom;

import java.util.Arrays;

public class Coefs implements Activity {

    @Override
    public void getIt(Polinom polinom) {
        System.out.println("Coefs:" + Arrays.toString(polinom.getCoefsArray()));
    }
}
