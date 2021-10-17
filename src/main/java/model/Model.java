package model;

import model.interfaces.Polinomable;

import java.util.List;

public abstract class Model implements interfaces.Model {

    public String getSuperClassSimpleName() {
        return ReflectionUtils.getSuperClassSimpleName(RationalPolinom.class);
    }

    public String getClassSimpleName() {
        return ReflectionUtils.getClassSimpleName(Polinom.class);
    }

    public String getPackageName() {
        return ReflectionUtils.getPackageName(Polinomable.class);
    }

    public List<String> getMethodInfo() {
        return ReflectionUtils.getMethodInfo(Polinom.class);
    }

    public List<String> listOfAnnotations() {
        return ReflectionUtils.listOfAnnotations(Polinom.class);
    }
}
