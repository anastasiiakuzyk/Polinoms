package patterns.behavioral.command;

public class AnnotationsCommand implements Command {

    ReflectionUtils utils;

    public AnnotationsCommand(ReflectionUtils utils) {
        this.utils = utils;
    }

    @Override
    public void execute(Class<?> objectClass) {
        utils.listOfAnnotations(objectClass).forEach(System.out::println);
    }
}