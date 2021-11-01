package patterns.behavioral.strategy;

import model.Polinom;

public class Degree implements Activity {

    @Override
    public void getIt(Polinom polinom) {
        System.out.println("Degree:" + polinom.getDegree());
    }
}
