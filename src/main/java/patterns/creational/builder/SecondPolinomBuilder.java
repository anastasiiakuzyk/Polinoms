package patterns.creational.builder;

public class SecondPolinomBuilder extends PolinomBuilder {

    @Override
    void buildX() {
        polinom.setX(2);
    }

    @Override
    void buildDegree() {
        polinom.setDegree(3);
    }

    @Override
    void buildCoefsArray() {
        polinom.setCoefsArray(new double[]{1, 2, 3, 4});
    }
}
