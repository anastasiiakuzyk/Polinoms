package model;

import annotations.ClassInfo;
import annotations.FieldInfo;
import annotations.MethodInfo;
import interfaces.Model;
import model.interfaces.Polinomable;
import printing.Formalization;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ClassInfo(numberOfFields = 7, numberOfGetters = 6)
public class Polinom implements Polinomable, Model, Cloneable {
    public static final int MIN = -100;
    public static final int MAX = 100;

    @FieldInfo(description = "degree of equation")
    protected int degree;
    protected double[] coefsArray;
    protected double x;
    protected double result;
    public String example;

    public Polinom() {
        setDegree(0);
        setX(0);
    }

    public Polinom(double x, int degree) {
        setDegree(degree);
        setX(x);
    }

    public Polinom(double x) {
        setDegree(0);
        setX(x);
    }

    public Polinom(double x, double[] coefs) {
        setCoefsArray(coefs);
        setX(x);
    }

    //TODO: @Test проверить в рамках ли числа, количество (degree + 1)
    private double[] generateCoefs(boolean isDouble) {
        double[] array = new double[degree + 1];

        for (int i = 0; i < degree + 1; i++) {
            array[i] = Math.floor(Math.random() * (MAX - MIN + 1) + MIN) +
                    (isDouble ? Formalization.doubleFormat(Math.random()) : 0);
        }
        return array;
    }

    @MethodInfo(author = "Nastya", date = "19.09.2021", description = "generates coefficients")
    private double[] generateCoefs() {
        return generateCoefs(true);
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
        if (coefsArray == null || coefsArray.length - 1 != degree) {
            coefsArray = generateCoefs();
        }
    }

    public double[] getCoefsArray() {
        return coefsArray;
    }

    public void setCoefsArray(double[] coefs) {
        for (int i = 0; i < coefs.length; i++) {
            coefs[i] = Formalization.doubleFormat(coefs[i]);
            if (coefs[i] < Polinom.MIN || coefs[i] > Polinom.MAX) {
                throw new IllegalArgumentException("Coefficients are out of bounds!");
            }
        }
        this.coefsArray = coefs;
        degree = coefs.length - 1;
    }

    public void setCoefsArrayRand(boolean isDouble) {
        double[] coefs = generateCoefs(isDouble);
        this.coefsArray = coefs;
        degree = coefs.length - 1;
    }

    public double getX() {
        return x;
    }

    @Override
    public double setX(double x) {
        this.x = Formalization.doubleFormat(x);
        return this.x;
    }

    @MethodInfo(date = "18.09.2021", description = "calculates the result of polinom")
    public double getResult() {
        result = 0;
        double[] coefsMultipliedByXInStage = getCoefsMultipliedByXInStage();
        for (int i = 0; i < degree + 1; i++) {
            this.result += coefsMultipliedByXInStage[i];
        }
        return result;
    }

    private double[] getCoefsMultipliedByXInStage() {
        double[] coefsMultipliedByXInStage = new double[degree + 1];
        for (int i = 0; i < degree + 1; i++) {
            coefsMultipliedByXInStage[i] = coefsArray[i] * (int) Math.pow(x, i);
        }
        return coefsMultipliedByXInStage;
    }

    //TODO: @Test должны быть иксы, количество их
    public String getEquationWithoutX() {
        String equationWithoutX = "";
        for (int i = 0; i < coefsArray.length; i++) {
            String coef = (coefsArray[i] < 0) ? "(" + coefsArray[i] + ")" : Double.toString(coefsArray[i]);
            equationWithoutX += coef + "*x^" + i + ((i != coefsArray.length - 1) ? " + " : "");
        }
        return equationWithoutX;
    }

    //TODO: @Test не должно быть иксов, могут быть только определенные символы и цифры
    public String getEquationWithX() {
        String equationWithX = "";
        for (int i = 0; i < coefsArray.length; i++) {
            String coef = (coefsArray[i] < 0) ? "(" + coefsArray[i] + ")" : Double.toString(coefsArray[i]);
            equationWithX += coef + "*" + (int) Math.pow(x, i) + ((i != coefsArray.length - 1) ? " + " : "");
        }
        return equationWithX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom = (Polinom) o;
        return degree == polinom.degree &&
                x == polinom.x &&
                Double.compare(polinom.result, result) == 0 &&
                Arrays.equals(coefsArray, polinom.coefsArray);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(degree, x, result, example);
        result1 = 31 * result1 + Arrays.hashCode(coefsArray);
        return result1;
    }

    @Override
    public String toString() {
        String print = "P(x) = ";
        print += getEquationWithoutX() + " = ";
        print += getEquationWithX() + " = ";
        print += Formalization.result(getResult()) +
                " (degree = " + degree + "; coefs: ";
        for (int i = 0; i < coefsArray.length; i++) {
            print += coefsArray[i] + ((i != coefsArray.length - 1) ? ", " : "");
        }
        print += "; x = " + x + ")";
        return print;
    }

    @Override
    public String getSuperClassSimpleName() {
        return ReflectionUtils.getSuperClassSimpleName(this.getClass());
    }

    @Override
    public String getClassSimpleName() {
        return ReflectionUtils.getClassSimpleName(this.getClass());
    }

    @Override
    public String getPackageName() {
        return ReflectionUtils.getPackageName(this.getClass());
    }

    @Override
    public List<String> getMethodInfo() {
        return ReflectionUtils.getMethodInfo(this.getClass());
    }

    @Override
    public List<String> listOfAnnotations() {
        return ReflectionUtils.listOfAnnotations(this.getClass());
    }
}
