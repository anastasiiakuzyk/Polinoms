package patterns.creational.builder;

import model.Polinom;

public class Director {
    PolinomBuilder builder;

    public void setBuilder(PolinomBuilder builder){
        this.builder = builder;
    }

    Polinom buildPolinom(){
        builder.createPolinom();
        builder.buildX();
        builder.buildDegree();
        builder.buildCoefsArray();

        Polinom polinom = builder.getPolinom();
        return polinom;
    }
}
