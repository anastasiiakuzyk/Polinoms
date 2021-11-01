package model.interfaces;

public interface Polinomable {
    double getResult();

    int getDegree();

    void setDegree(int degree);

    void setCoefsArray(double[] coefs);

    double[] getCoefsArray();

    String getEquationWithoutX();

    String getEquationWithX();

    double setX(double x);

    double getX();

    void setCoefsArrayRand(boolean isDouble);

    String getClassSimpleName();
}

