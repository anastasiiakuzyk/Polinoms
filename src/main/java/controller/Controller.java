package controller;

import interfaces.Model;
import interfaces.View;
import model.Polinom;
import model.RationalPolinom;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        view.printIntro();
        label:
        do {
            String pOrR = view.ask("Enter 'p' for Polinom 'r' for Rational Polinom or \"end\" to end:");
            switch (pOrR) {
                case "p":
                    model = choosePolinomConstructor();
                    view.printResult(model);
                    break;
                case "r":
                    view.createNumerator();
                    Polinom numerator = choosePolinomConstructor();
                    double[] coefsArrayNum = numerator.getCoefsArray();

                    view.createDenumerator();
                    Polinom denumerator = choosePolinomConstructorDenumerator(numerator);

                    model = new RationalPolinom(coefsArrayNum, denumerator);

                    view.printResult(model);
                    break;
                case "end":
                    break label;
                default:
                    view.printInputCorrectCommand();
                    break;
            }
        } while (true);
    }

    private Polinom choosePolinomConstructor() {
        Polinom polinomInstance;
        do {
            String dOrC = view.ask("Enter 'd' for degree or 'c' for coefficients:");
            if (dOrC.equals("d")) {
                int degree = view.askDegree();
                double x = view.askX();
                polinomInstance = new Polinom(x, degree);
                break;
            } else if (dOrC.equals("c")) {
                double[] coefs = view.askCoefs();
                double x = view.askX();
                polinomInstance = new Polinom(x, coefs);
                break;
            } else {
                view.printInputCorrectCommand();
            }
        } while (true);
        return polinomInstance;
    }

    private Polinom choosePolinomConstructorDenumerator(Polinom numerator) {
        Polinom polinomInstance;
        double xNum = numerator.getX();
        do {
            String dOrC = view.ask("Enter 'd' for degree or 'c' for coefficients:");
            if (dOrC.equals("d")) {
                int degree = view.askDegree();
                polinomInstance = new Polinom(xNum, degree);
                break;
            } else if (dOrC.equals("c")) {
                double[] coefs = view.askCoefs();
                polinomInstance = new Polinom(xNum, coefs);
                break;
            } else {
                view.printInputCorrectCommand();
            }
        } while (true);
        return polinomInstance;
    }



    public void processReflexion() {
        view.printMenu();
        String variant = view.ask("Choose variant: ");
        switch (variant) {
            case "get superclass":
                view.printInformation(model.getSuperClassSimpleName());
                break;
            case "get package":
                view.printInformation(model.getPackageName());
                break;
            case "get class":
                view.printInformation(model.getClassSimpleName());
                break;
            case "get methods":
                model.getMethodInfo().forEach(view::printInformation);
                break;
            case "invoke methods":
                model.listOfAnnotations().forEach(view::printInformation);
                break;
            case "exit":
                System.exit(0);
        }
    }

    public String invite() {
        return view.ask("Hello, how are you?");
    }

    public double processModel() throws Exception {
        if (model == null) {
            throw new Exception("Polinom unset!!");
        }
        return model.getResult();
    }

}
