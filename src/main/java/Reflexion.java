import annotations.ClassInfo;
import annotations.FieldInfo;
import annotations.MethodInfo;
import model.interfaces.Polinomable;
import model.Polinom;
import model.ProxyClass;
import model.RationalPolinom;
import printing.Formalization;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflexion {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        Formalization.title("Calcutating polinom");
        Polinom polinom = new Polinom(1, 1);
        polinom.getResult();
        System.out.println(polinom);

        Formalization.title("Calcutating polinom");
        Polinom polinom2 = new Polinom();
        polinom2.setCoefsArray(new double[]{1, 2, 3});
        polinom2.setDegree(2);
        polinom2.getResult();
        System.out.println(polinom2);

        Formalization.title("Calcutating polinom");
        Polinom polinom3 = new Polinom(2, new double[]{1, 2, 3});
        polinom3.getResult();
        System.out.println(polinom3);

        Formalization.title("Calcutating rational polinom");
        Polinom rationalPolinom = new RationalPolinom(3, polinom);
        rationalPolinom.getResult();
        System.out.println(rationalPolinom);


        //Reflexion API
        //CLASSES
        //getting classes using different variants
        Formalization.title("Class names");
        Class<Polinom> polinomClass = Polinom.class;
        Class<?> polinomClass1 = Class.forName("model.Polinom");
        Class<? extends Polinom> rationalPolinomClass = rationalPolinom.getClass();
        Class<Polinomable> polinomableInterface = Polinomable.class;

        //getting names of classes
        System.out.println(polinomClass.getName());
        System.out.println(polinomClass1.getName());
        System.out.println(rationalPolinomClass.getName());
        System.out.println(polinomableInterface.getName());
        System.out.println(polinomableInterface.getSimpleName());

        //checking modifiers
        boolean isPolinomClassPublic = Modifier.isPublic(polinomClass.getModifiers());
        System.out.println("model.Polinom class is " + (isPolinomClassPublic ? "public" : "not public"));
        boolean isPolinomiableInterface = Modifier.isInterface(polinomableInterface.getModifiers());
        System.out.println("Polinomiable is " + (isPolinomiableInterface ? "interface" : "not interface"));

        //getting packages
        Formalization.title("Getting packages");
        System.out.println(polinomableInterface.getPackage().getName());

        //getting class annotations
        Formalization.title("Annotations of " + polinomClass.getName());
        System.out.println(model.ReflectionUtils.listOfAnnotations(polinomClass));

        //getting superclass
        Formalization.title("Superclass of " + rationalPolinomClass.getName() + " is");
        System.out.println(model.ReflectionUtils.superClassName(rationalPolinomClass));

        //getting realized model.interfaces
        Class rationalPolinomClassSuperclass = rationalPolinomClass.getSuperclass();
        Formalization.title("Interfaces realized by " + rationalPolinomClassSuperclass.getName());
        System.out.println(model.ReflectionUtils.getRealizedInterfaces(rationalPolinomClassSuperclass));

        Formalization.title("Modifiers of " + polinomClass.getName());
        int polinomClassModifiers = polinomClass.getModifiers();
        System.out.println(Modifier.toString(polinomClassModifiers));

        Formalization.title("Names of interface");
        System.out.println(polinomableInterface.getName() + ", " + polinomableInterface.getSimpleName() +
                ", package name: " + polinomableInterface.getPackage().getName());


        //CONSTRUCTORS
        //getting constructors
        Formalization.title("Constructors of " + rationalPolinomClass.getName() + " with parameters");
        System.out.println(model.ReflectionUtils.constructorsWithParametrs(rationalPolinomClass));

        Formalization.title("Getting constructor by parameters types");
        Constructor<Polinom> polinomClassConstructor = polinomClass.getConstructor(double.class, int.class);
        Class<?>[] polinomClassConstructorParameterTypes = polinomClassConstructor.getParameterTypes();
        System.out.print(polinomClassConstructor + " (");
        for (Class type : polinomClassConstructorParameterTypes) {
            System.out.print(type + " ");
        }
        System.out.println(")");

        //creating instance from a constructor
        Polinom instanceOfPolinom = polinomClassConstructor.newInstance(2, 3);

        //FIELDS
        //getting fields
        Formalization.title("Printing filed names");
        Field[] fields = polinomClass.getFields();
        Field polinomClassDeclaredField = polinomClass.getDeclaredField("result");
        Field polinomClassPublicField = polinomClass.getField("example");
        System.out.println(polinomClassDeclaredField + " " + polinomClassPublicField);

        //getting field name
        String polinomClassField = fields[0].getName();
        Formalization.title("Name of the first field of " + polinomClass.getName());
        System.out.println(polinomClassField);

        //getting filed type
        Class<?> polinomClassDeclaredFieldType = polinomClassDeclaredField.getType();

        //setting filed value
        polinomClassPublicField.set(polinom, "hello");
        Formalization.title("Setting new value for filed");
        System.out.println(polinom.example);

        //accessing private fileds
        polinomClassDeclaredField.setAccessible(true);
        Object result = polinomClassDeclaredField.get(polinom);

        Formalization.title("Printing the result private field");
        System.out.println(result);

        Formalization.title("Fileds of " + polinomClass.getName() + " with names, annotations, modifiers and types");
        System.out.println(model.ReflectionUtils.getFields(polinomClass));

        //METHODSR
        Method[] methods = polinomClass.getMethods();
        Method[] declaredMethods = polinomClass.getDeclaredMethods();
        Method getResult = polinomClass.getMethod("getResult");
        Class<?>[] parameterTypes = getResult.getParameterTypes();
        Class<?> returnType = getResult.getReturnType();
        Formalization.title("Parameter types and return type of " + getResult.getName() + " method");
        System.out.print(returnType + " " + getResult.getName() + " (");
        for (Class type : parameterTypes) {
            System.out.print(type + " ");
        }
        System.out.println(")");

        getResult.invoke(polinom);
        Formalization.title("Defining if method is getter or setter");
        System.out.println(model.ReflectionUtils.defineGettersAndSetters(Polinom.class));

        //accessing private methods
        Method generateCoefs = polinomClass.getDeclaredMethod("generateCoefs");
        generateCoefs.setAccessible(true);
        double[] generatedCoefs = (double[]) generateCoefs.invoke(polinom);

        Formalization.title("Printing the result of invoking of generateCoefs method");
        System.out.println(Arrays.toString(generatedCoefs));

        Formalization.title("Invoking methods with annotations");
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(MethodInfo.class)) {
                method.invoke(polinom);
                System.out.println("Method " + method.getName() + " invoked ");
            }
        }

        Formalization.title("Methods of " + rationalPolinomClass.getName() + " with annotations, modifiers and parameter types");
        for (Method method : rationalPolinomClass.getMethods()) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(MethodInfo.class)) {
                for (Annotation annot : method.getDeclaredAnnotations()) {
                    System.out.print(annot + " ");
                }
            }
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            System.out.print(method.getName() + " (");
            for (Class param : method.getParameterTypes()) {
                System.out.print(param.getName() + " ");
            }
            System.out.println(")");
        }

        Formalization.title("Proxy");
        Polinomable proxy = (Polinomable) ProxyClass.newProxyInstance(polinom);
        int degree = proxy.getDegree();
        System.out.println("Degree is: " + degree);
//        proxy.setDegree(5);

    }
}
