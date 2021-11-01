package patterns.behavioral.command;

import model.Polinom;
import reflexion.ReflectionUtils;

import java.util.List;

public class PolinomRefl {
    Command superClassSimpleName;
    Command classSimpleName;
    Command packageName;
    Command methodInfo;
    Command annotations;

    public PolinomRefl(Command superClassSimpleName, Command classSimpleName, Command packageName, Command methodInfo, Command annotations) {
        this.superClassSimpleName = superClassSimpleName;
        this.classSimpleName = classSimpleName;
        this.packageName = packageName;
        this.methodInfo = methodInfo;
        this.annotations = annotations;
    }


    public void getSuperClassSimpleName() {
        superClassSimpleName.execute(Polinom.class);
    }

    public void getClassSimpleName() {
        classSimpleName.execute(Polinom.class);
    }

    public void getPackageName() {
        packageName.execute(Polinom.class);
    }

    public void getMethodInfo() {
        methodInfo.execute(Polinom.class);
    }

    public void listOfAnnotations() {
        annotations.execute(Polinom.class);
    }
}
