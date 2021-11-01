package patterns.behavioral.template;

import printing.Formalization;

public abstract class PolinomTemplate {
    public void showPolinomInfo() {
        Formalization.title("Printing " + showTypeOfPolinom() + " info");
        System.out.print("P(x) = ");
        showPolinomResult();
    }

    protected abstract String showTypeOfPolinom();

    public abstract void showPolinomResult();

}
