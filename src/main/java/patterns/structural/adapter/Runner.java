package patterns.structural.adapter;


import interfaces.Model;
import model.Polinom;

public class Runner {
    public static void main(String[] args) {
        Model model = new Polinom();
        System.out.println(model.getSuperClassSimpleName());
        System.out.println(model.getPackageName());
        System.out.println(model.getClassSimpleName());
        model.getMethodInfo().forEach(System.out::println);
        model.listOfAnnotations().forEach(System.out::println);
    }
}
