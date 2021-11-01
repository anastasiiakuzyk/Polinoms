package model;

import annotations.ClassInfo;
import annotations.FieldInfo;
import annotations.MethodInfo;
import model.interfaces.Polinomable;
import patterns.behavioral.template.PolinomTemplate;
import printing.Formalization;

import java.util.Objects;

@ClassInfo(numberOfGetters = 4, numberOfFields = 2)
public class RationalPolinom extends Polinom {
    @FieldInfo(description = "instance of model.Polinom class")
    private Polinomable denumerator;
    private double result;

    public RationalPolinom() {
        super();
        denumerator = new Polinom();
    }

    public RationalPolinom(double x, int degreeNum) {
        super(x, degreeNum);
        denumerator = new Polinom(x);
    }

    public RationalPolinom(double x, double[] coefsNum) {
        super(x, coefsNum);
        denumerator = new Polinom();
    }

    public RationalPolinom(Polinomable denumerator) {
        super(denumerator.getX());
        this.denumerator = denumerator;
    }

    public RationalPolinom(Polinomable numerator, Polinomable denumerator) {
        super(numerator.getX(), numerator.getCoefsArray());
        denumerator.setX(numerator.getX());
        this.denumerator = denumerator;
    }

    public RationalPolinom(int degreeNum, Polinomable denumerator) {
        super(denumerator.getX(), degreeNum);
        this.denumerator = denumerator;
    }

    public RationalPolinom(double[] coefsNum, Polinomable denumerator) {
        super(denumerator.getX(), coefsNum);
        this.denumerator = denumerator;
    }

    public RationalPolinom(double x, int degreeNum, int degreeDenum) {
        super(x, degreeNum);
        denumerator = new Polinom(x, degreeDenum);
    }

    public RationalPolinom(double x, double[] coefsNum, double[] coefsDenum) {
        super(x, coefsNum);
        denumerator = new Polinom(x, coefsDenum);
    }


    @Override
    protected String showTypeOfPolinom() {
        return "rational polinom";
    }

    @Override
    public void showPolinomResult() {
        System.out.println(getResult());
    }


    @Override
    @MethodInfo(date = "19.09.2021", description = "calculates rational polinom")
    public double getResult() {
        double numeratorCalculated = super.getResult();
        double denumeratorCalculated = denumerator.getResult();
        if (denumeratorCalculated == 0) {
            throw new IllegalArgumentException("Denumerator can't be 0!");
        }
        result = numeratorCalculated / denumeratorCalculated;
        return result;
    }

    public double[] getNumeratorCoefs() {
        return super.getCoefsArray();
    }

    public double[] getDenumeratorCoefs() {
        return denumerator.getCoefsArray();
    }

    public Polinom getNumerator() throws CloneNotSupportedException {
        return (Polinom) super.clone();
    }

    public Polinom getDenumerator() {
        return (Polinom) denumerator;
    }

    public void setDenumerator(Polinom denumerator) {
        this.denumerator = denumerator;
    }

    public void setDenumeratorDegree(int degree) {
        denumerator.setDegree(degree);
    }

    public void setDenumerator(double x, double[] coefs) {
        denumerator.setX(x);
        denumerator.setCoefsArray(coefs);
    }

    public double setDenumerator(double x) {
        return denumerator.setX(x);
    }

    public void setDenumerator() {
        denumerator.setCoefsArrayRand(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RationalPolinom that = (RationalPolinom) o;
        Polinom thatDenumerator = that.getDenumerator();
        Polinom thatNumerator = null;
        try {
            thatNumerator = that.getNumerator();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        assert thatNumerator != null;

        Polinom thisDenumerator = this.getDenumerator();
        Polinom thisNumerator = null;
        try {
            thisNumerator = this.getNumerator();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        assert thisNumerator != null;

        return Double.compare(that.result, this.result) == 0 && Objects.equals(thisDenumerator, thatDenumerator)
                && Objects.equals(thisNumerator, thatDenumerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denumerator, result);
    }


    @Override
    public String toString() {
        String print = "\t\t" + super.getEquationWithoutX() + "\n";
        print += "R(x) =  " + "-".repeat(Math.max(super.getEquationWithoutX().length(), denumerator.getEquationWithoutX().length())) + "=\n";
        print += "\t\t" + denumerator.getEquationWithoutX() + "\n";
        print += "\t\t" + super.getEquationWithX() + "\n";
        print += "\t\t" + "-".repeat(Math.max(super.getEquationWithX().length(), denumerator.getEquationWithX().length()))
                + " = " + Formalization.doubleFormat(super.getResult()) + "/" + Formalization.doubleFormat(denumerator.getResult()) + " = " +
                Formalization.result(getResult());
        print += "\n\t\t" + denumerator.getEquationWithX() + "\n";
        return print;
    }
}
