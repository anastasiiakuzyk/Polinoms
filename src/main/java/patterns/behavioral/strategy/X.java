package patterns.behavioral.strategy;

import model.Polinom;

public class X implements Activity {

    @Override
    public void getIt(Polinom polinom) {
        System.out.println("X:" + polinom.getX());
    }
}
