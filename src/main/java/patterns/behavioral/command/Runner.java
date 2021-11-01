package patterns.behavioral.command;

public class Runner {
    public static void main(String[] args) {
        ReflectionUtils utils = new ReflectionUtils();

        PolinomRefl polinom = new PolinomRefl(
                new SuperClassSimpleNameCommand(utils),
                new ClassSimpleNameCommand(utils),
                new PackageNameCommand(utils),
                new MethodInfoCommand(utils),
                new AnnotationsCommand(utils)
        );

        polinom.getSuperClassSimpleName();
        polinom.getClassSimpleName();
        polinom.getPackageName();
        polinom.getMethodInfo();
        polinom.listOfAnnotations();
    }
}
