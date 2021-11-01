package reflexion;

import annotations.ClassInfo;
import annotations.FieldInfo;
import model.Polinom;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReflectionUtils {

    public static List<String> getMethodInfo(Class<?> objectClass) {
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


    public static List<String> listOfAnnotations(Class<?> polinomClass) {
        List<String> list = new ArrayList<>();

        for (Annotation annotation : polinomClass.getAnnotations()) {
            if (annotation instanceof ClassInfo) {
                list.add(annotation.toString());
            }
        }
        return list;
    }


    public static String getPackageName(Class<?> objectClass) {
        return "Package name = " + objectClass.getPackage().getName();
    }

    public static String getClassSimpleName(Class<?> objectClass) {
        return "Class name = " + objectClass.getSimpleName();
    }

    public static String getSuperClassSimpleName(Class<?> objectClass) {
        Class<?> superclass = objectClass.getSuperclass();
        return "Super class name = " + getClassSimpleName(superclass);
    }




    public static String constructorsWithParametrs(Class<? extends Polinom> rationalPolinomClass) {
        Constructor<?>[] rationalPolinomClassConstructors = rationalPolinomClass.getConstructors();
        String str = "";
        for (Constructor constr : rationalPolinomClassConstructors) {
            str += constr.getName() + "(";
            for (Class param : constr.getParameterTypes()) {
                str += param.getName() + " ";
            }
            str += ")\n";
        }
        return str;
    }

    public static String listOfAnnotations1(Class<Polinom> polinomClass) {
        String str = "";
        for (Annotation annotation : polinomClass.getAnnotations()) {
            if (annotation instanceof ClassInfo) {
                str += annotation;
            }
        }
        return str;
    }

    public static String superClassName(Class cl) {
        Class<?> superclass = cl.getSuperclass();
        return superclass.getName();
    }

    public static String getRealizedInterfaces(Class cl) {
        Class<?>[] interfaces = cl.getInterfaces();
        String str = "";
        for (Class aClass : interfaces) {
            str += aClass.getName() + " ";
        }
        return str;
    }

    public static String getFields(Class cl){
        String str = "";
        for (Field field : cl.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(FieldInfo.class)) {
                for (Annotation annot : field.getDeclaredAnnotations()) {
                    str += annot + " ";
                }
            }
            int modifiers = field.getModifiers();
            str += Modifier.toString(modifiers) + " " + field.getName() + "\n";

        }
        return str;
    }

    public static String defineGettersAndSetters(Class aClass) {
        Method[] methods = aClass.getMethods();

        String str = "";
        for (Method method : methods) {
            if (isGetter(method)) str += "getter: " + method+"\n";
            if (isSetter(method)) str += "setter: " + method+"\n";
        }
        return str;
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }

}
