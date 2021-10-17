import model.Polinom;
import model.RationalPolinom;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalPolinomTest {
    static RationalPolinom polinom;
    static Polinom polinom1;

    @Test
    @DisplayName("Negative: No memory allocated for the object")
    public void nullObject() {
        polinom = null;
        assertNull(polinom);
    }

    @Test
    @DisplayName("Negative: Check denumerator is zero")
    public void throwExceptionOnZeroDenumerator() {
        polinom = new RationalPolinom(6, new double[]{10, 33, 44});
        Polinom zeroResult = null;
        double result = -1;
        while (result != 0) {
            zeroResult = new Polinom(2, 2);
            result = zeroResult.getResult();
        }
        polinom.setDenumerator(zeroResult);
        assertThrows(IllegalArgumentException.class, () -> {
            polinom.getResult();
        });
    }

    //the number of coefficients should be one less than degree of polinom
    @Test
    @DisplayName("Positive: Number of coefficients corresponds to degree")
    public void numberOfNumeratorCoefs() throws CloneNotSupportedException {
        polinom = new RationalPolinom(5, 3);
        double[] coefsArray = polinom.getNumeratorCoefs();
        assertEquals(coefsArray.length, polinom.getNumerator().getDegree() + 1);
    }

    //the number of coefficients should be one less than degree of polinom
    @Test
    @DisplayName("Positive: Number of coefficients corresponds to degree")
    public void numberOfDenumeratorCoefs() {
        polinom = new RationalPolinom(5, new double[]{10, 33, 44}, new double[]{1, 3, 4});
        double[] coefsArray = polinom.getDenumeratorCoefs();
        assertEquals(coefsArray.length, polinom.getDenumerator().getDegree() + 1);
    }

    @Test
    @DisplayName("Positive: Creating an instance")
    public void rationalPolinomInstance() {
        polinom = new RationalPolinom();
        assertInstanceOf(RationalPolinom.class, polinom);
    }

    @Test
    @DisplayName("Negative: Different objects created")
    public void test() {
        Polinom denumerator = new Polinom(3, new double[]{1, 1, 1});
        polinom = new RationalPolinom(1, new double[]{2, 2, 2}, new double[]{1, 1, 1});
        polinom1 = new RationalPolinom(new double[]{2, 2, 2}, denumerator);
        assertNotSame(polinom, polinom1);
    }

    @AfterEach
    public void printPolinom() {
        try {
            System.out.println(polinom);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    static void printAfterModifications() {
        System.out.println("Polinoms in the end:");
        System.out.println(polinom);
        System.out.println(polinom1);
    }
}