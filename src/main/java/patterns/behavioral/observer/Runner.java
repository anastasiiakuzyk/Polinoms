package patterns.behavioral.observer;

import model.Polinom;

public class Runner {
    public static void main(String[] args) {
        PolinomShare share = new PolinomShare();
        Polinom polinom1 = new Polinom();
        share.addPolinom(polinom1);
        Polinom polinom2 = new Polinom();
        share.addPolinom(polinom2);

        Observer firstSubscriber = new Subscriber("Nastya");
        Observer secondSubscriber = new Subscriber("Vasya");

        share.addObserver(firstSubscriber);
        share.addObserver(secondSubscriber);

        Polinom polinom3 = new Polinom();
        share.addPolinom(polinom3);
        share.removePolinom(polinom1);
    }
}
