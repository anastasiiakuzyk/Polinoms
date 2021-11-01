package patterns.behavioral.command;

public class ClassSimpleNameCommand implements Command {

    ReflectionUtils utils;

    public ClassSimpleNameCommand(ReflectionUtils utils) {
        this.utils = utils;
    }

    @Override
    public void execute(Class<?> objectClass) {
        System.out.println(utils.getClassSimpleName(objectClass));
    }
}
