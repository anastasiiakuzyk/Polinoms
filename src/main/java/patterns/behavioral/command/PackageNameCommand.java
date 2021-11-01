package patterns.behavioral.command;

public class PackageNameCommand implements Command{

    ReflectionUtils utils;

    public PackageNameCommand(ReflectionUtils utils) {
        this.utils = utils;
    }

    @Override
    public void execute(Class<?> objectClass) {
        System.out.println(utils.getPackageName(objectClass));
    }
}
