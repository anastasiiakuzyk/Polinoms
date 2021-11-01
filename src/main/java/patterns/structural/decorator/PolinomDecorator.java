package patterns.structural.decorator;

public class PolinomDecorator implements PolinomResult{

    PolinomResult polinom;

    public PolinomDecorator(PolinomResult polinom) {
        this.polinom = polinom;
    }

    @Override
    public String getSpecialInfo() {
        return polinom.getSpecialInfo();
    }
}
