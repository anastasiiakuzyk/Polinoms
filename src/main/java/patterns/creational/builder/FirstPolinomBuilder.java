package patterns.creational.builder;

public class FirstPolinomBuilder extends PolinomBuilder {
    @Override
    void buildX() {
        polinom.setX(1);
    }

    @Override
    void buildDegree() {
        polinom.setDegree(2);
    }

    @Override
    void buildCoefsArray() {
        polinom.setCoefsArray(new double[]{1, 2, 3});
    }
}
