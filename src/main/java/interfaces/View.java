package interfaces;

import model.interfaces.Polinomable;

public interface View {
    void printIntro();

    void printInformation(String information);

    void printMenu();

    String ask(String message);

    int askDegree();

    double askX();

    double[] askCoefs();

    void createNumerator();

    void createDenumerator();

    void printInputCorrectCommand();

    void printResult(Polinomable polinom);


}
