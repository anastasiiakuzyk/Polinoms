import model.Polinom;
import model.RationalPolinom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reflexion.ReflectionUtils;
import reflexion.Reflexion;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ReflexionTest {

    @Test
    @DisplayName("Positive: Number of setters + getters")
    public void numberOfSettersAndGetters() {
        String gettersAndSetters = ReflectionUtils.defineGettersAndSetters(Polinom.class);
        assertEquals(16, gettersAndSetters.split("etter").length);
    }

//    @Test
//    @DisplayName("Negative: method is not setter")
//    public void isNotSetter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Method isSetterMethod = reflexion.Reflexion.class.getDeclaredMethod("isSetter", Method.class);
//        isSetterMethod.setAccessible(true);
//        Method getEquationWithoutX = Polinom.class.getMethod("getEquationWithoutX");
//        boolean isSetter = (boolean) isSetterMethod.invoke(reflexion.Reflexion.class, getEquationWithoutX);
//
//        Assertions.assertFalse(isSetter);
//    }
//
//    @Test
//    @DisplayName("Positive: method is getter")
//    public void isGetter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Method isGetterMethod = reflexion.Reflexion.class.getDeclaredMethod("isGetter", Method.class);
//        isGetterMethod.setAccessible(true);
//        Method getEquationWithoutX = Polinom.class.getMethod("getEquationWithoutX");
//        boolean isGetter = (boolean) isGetterMethod.invoke(reflexion.Reflexion.class, getEquationWithoutX);
//
//        assertTrue(isGetter);
//    }

    @Test
    public void numberOfConstructors() {
        String constructors = ReflectionUtils.constructorsWithParametrs(RationalPolinom.class);
        int number = constructors.split(RationalPolinom.class.getName()).length;
        assertEquals(9, number);
    }

//    @Test
//    @DisplayName("Class contains annotation")
//    public void hasAnnotation() {
//        boolean contains = reflexion.ReflectionUtils.listOfAnnotations(Polinom.class).contains("ClassInfo");
//        assertTrue(contains);
//    }

    @Test
    public void classFields() {
        String expected = "public static final MIN\n" +
                "public static final MAX\n" +
                "@annotations.FieldInfo(author=\"Anastasiia Kuzyk\", description=\"degree of equation\") protected degree\n" +
                "protected coefsArray\n" +
                "protected x\n" +
                "protected result\n" +
                "public example\n";
        String actual = ReflectionUtils.getFields(Polinom.class);
        assertEquals(expected, actual);
    }

    @Test
    public void classInterfaces() {
        String interfaces = ReflectionUtils.getRealizedInterfaces(Polinom.class);
        assertEquals("model.interfaces.Polinomable interfaces.Model java.lang.Cloneable ", interfaces);
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(300), () -> {
            Reflexion.main(new String[]{});
        });
    }
}
