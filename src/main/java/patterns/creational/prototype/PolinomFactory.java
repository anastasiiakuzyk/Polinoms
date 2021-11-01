package patterns.creational.prototype;

import model.Polinom;

public class PolinomFactory {
    Polinom polinom;

    public PolinomFactory(Polinom polinom) {
        this.polinom = polinom;
    }

    public void setPolinom(Polinom polinom) {
        this.polinom = polinom;
    }

    Polinom clonePolinom(){
        return (Polinom) polinom.copy();
    }
}
