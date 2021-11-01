package patterns.behavioral.strategy;

import model.Polinom;

public class Runner  {
    public static void main(String[] args) {
        Polinom polinom = new Polinom(2, 5);
        polinom.setActivity(new X());
        polinom.executeActivity();
        polinom.setActivity(new Degree());
        polinom.executeActivity();
        polinom.setActivity(new Coefs());
        polinom.executeActivity();
    }
}
