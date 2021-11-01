package patterns.behavioral.command;

import annotations.ClassInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReflectionUtils {

    public List<String> getMethodInfo(Class<?> objectClass) {
        List<String> resultList = new LinkedList<>();
        for (Method method : objectClass.getDeclaredMethods()) {
            resultList.add("Method name = " + method.getName());
            Class<?>[] types = method.getParameterTypes();
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (types.length != 0) {
                resultList.add("\tParameters types:");
                Arrays.stream(types).forEach(type -> resultList.add("\t\t" + type.getSimpleName()));
            }
            if (annotations.length != 0) {
                resultList.add("\tAnnotations:");
                Arrays.stream(annotations).forEach(annotation -> resultList.add("\t\t" + annotation.annotationType().getSimpleName()));
            }
        }
        return resultList;
    }


    public List<String> listOfAnnotations(Class<?> polinomClass) {
        List<String> list = new ArrayList<>();

        for (Annotation annotation : polinomClass.getAnnotations()) {
            if (annotation instanceof ClassInfo) {
                list.add(annotation.toString());
            }
        }
        return list;
    }


    public String getPackageName(Class<?> objectClass) {
        return "Package name = " + objectClass.getPackage().getName();
    }

    public String getClassSimpleName(Class<?> objectClass) {
        return "Class name = " + objectClass.getSimpleName();
    }

    public String getSuperClassSimpleName(Class<?> objectClass) {
        Class<?> superclass = objectClass.getSuperclass();
        return "Super class name = " + getClassSimpleName(superclass);
    }
}
