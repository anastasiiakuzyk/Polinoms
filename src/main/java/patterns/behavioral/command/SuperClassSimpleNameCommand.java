package patterns.behavioral.command;

public class SuperClassSimpleNameCommand implements Command {

    ReflectionUtils utils;

    public SuperClassSimpleNameCommand(ReflectionUtils utils) {
        this.utils = utils;
    }

    @Override
    public void execute(Class<?> objectClass) {
        System.out.println(utils.getSuperClassSimpleName(objectClass));
    }
}
