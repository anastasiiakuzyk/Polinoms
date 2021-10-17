package view;

import model.interfaces.Polinomable;

import java.util.Scanner;

public class View implements interfaces.View {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printIntro() {
        System.out.println("Program calculating polinoms started");
    }

    @Override
    public void printInformation(String information) {
        System.out.println(information);
    }

    @Override
    public void printMenu() {
        System.out.println("Possible variants: 'get superclass', 'get package', 'get class', 'get methods', 'get annotations'");
    }

    @Override
    public String ask(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public int askDegree() {
        System.out.println("Enter degree(integer) of polinom:");
        String s = scanner.nextLine();
        return Integer.parseInt(s);
    }

    @Override
    public double askX() {
        System.out.println("Enter x(integer/double):");
        String s = scanner.nextLine();
        return Double.parseDouble(s);
    }

    @Override
    public double[] askCoefs() {
        System.out.println("Enter coefficients(integer/double, ex: 1 2 3/1.1 2.2 3.3) separated with space (' '):");
        String s = scanner.nextLine();
        String[] coefsStr = s.split(" ");
        int size = coefsStr.length;
        double[] coefsArr = new double[size];
        for (int i = 0; i < size; i++) {
            coefsArr[i] = Double.parseDouble(coefsStr[i]);
        }
        return coefsArr;
    }

    @Override
    public void createNumerator() {
        System.out.println("Create numerator:");
    }

    @Override
    public void createDenumerator() {
        System.out.println("Create denumerator:");
    }

    @Override
    public void printInputCorrectCommand() {
        System.out.println("Input is invalid. Input correct command.");
    }

    @Override
    public void printResult(Polinomable polinom) {
        System.out.println(polinom);
    }
}
