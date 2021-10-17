package interfaces;

import model.interfaces.Polinomable;

import java.util.List;

public interface Model extends Polinomable {
    String getSuperClassSimpleName();
    String getClassSimpleName();
    String getPackageName();
    List<String> getMethodInfo();
    List<String> listOfAnnotations();
}
