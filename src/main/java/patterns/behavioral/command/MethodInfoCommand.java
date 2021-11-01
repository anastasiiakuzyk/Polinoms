package patterns.behavioral.command;


public class MethodInfoCommand implements Command{
    ReflectionUtils utils;

    public MethodInfoCommand(ReflectionUtils utils) {
        this.utils = utils;
    }

    @Override
    public void execute(Class<?> objectClass) {
        utils.getMethodInfo(objectClass).forEach(System.out::println);
    }
}
