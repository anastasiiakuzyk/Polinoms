import model.Polinom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import printing.Formalization;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class PolinomTest {
    Polinom polinom;
    static int counter = 0;

    @BeforeEach
    public void init() {
        if (counter == 0) {
            polinom = new Polinom();
            counter++;
        } else if (counter == 1) {
            polinom = new Polinom(6, new double[]{10, 33, 44});
            counter++;
        } else if (counter == 2) {
            polinom = new Polinom(5, 3);
            counter = 0;
        }

        Formalization.title("Calcutating polinom");
        polinom.getResult();
        System.out.println(polinom);
    }

    //the number of coefficients should be one less than degree of polinom
    @Test
    @DisplayName("Positive: Number of coefficients corresponds to degree")
    public void numberOfCoefs() {
        double[] coefsArray = polinom.getCoefsArray();
        assertEquals(coefsArray.length, polinom.getDegree() + 1);
    }

    //coefficients of polinom should be in range (min = -100, max = 100)
    @Test
    @DisplayName("Positive: Check coefficients are in range(from -100 to 100)")
    public void coefsInRange() {
        double[] coefsArray = polinom.getCoefsArray();
        boolean isInRange = false;
        for (double coef : coefsArray) {
            isInRange = coef >= Polinom.MIN && coef <= Polinom.MAX;
            if (!isInRange) {
                break;
            }
        }
        assertTrue(isInRange);
    }

    @Test
    @DisplayName("Positive: Check result")
    public void testResult() {
        int result = 0;
        for (int i = 0; i < polinom.getDegree() + 1; i++) {
            result += polinom.getCoefsArray()[i] * (int) Math.pow(polinom.getX(), i);
        }
        assertEquals(result, polinom.getResult());
    }

    @Test
    @DisplayName("Negative: Check coefficients are in not range(from -100 to 100)")
    public void throwExceptionOnSettingWrongCoffs() {
        assertThrows(IllegalArgumentException.class, () -> {
            polinom.setCoefsArray(new double[]{101, 99});
        });
    }

    //coefs are changed, so degree is not the same in most of cases
    @Test
    @DisplayName("Positive: Degree is changed because of coefficients are changed")
    public void degreeChanging() {
        int degreeBefore = polinom.getDegree();
        polinom.setCoefsArray(new double[]{1, 2, 3, 4, 5});
        assumeFalse(polinom.getDegree() == degreeBefore, "Degree is not changed");
    }

    @Test
    @DisplayName("Positive: Number of X in equation corresponds to degree")
    public void xCountEqualsDegree() {
        String equationWithoutX = polinom.getEquationWithoutX();
        int xCount = equationWithoutX.split("x").length - 1;
        assertEquals(xCount, polinom.getDegree() + 1);
    }

    @Test
    @DisplayName("Positive: Equation contains X")
    public void isXPresentInEquation() {
        String equationWithoutX = polinom.getEquationWithoutX();
        assertTrue(equationWithoutX.contains("x"));
    }

    @Test
    @DisplayName("Negative: Equation doesn't contain X")
    public void isXNotPresentInEquation() {
        String equationWithoutX = polinom.getEquationWithX();
        assertFalse(equationWithoutX.contains("x"));
    }

    //almost every polinom is primitive
    @Test
    @DisplayName("Positive: Almost every polinom is primitive")
    public void isPrimitive() {
        polinom.setCoefsArrayRand(false);
        double[] coefsArray = polinom.getCoefsArray();
        assumeTrue(gcd(coefsArray) == 1, "model.Polinom is not primitive");
    }

    //checking not primitive polinom
    @Test
    @DisplayName("Negative: Setting coefficients, that give not primitive polinom")
    public void isNotPrimitive() {
        polinom.setCoefsArray(new double[]{7, 7, 7});
        assertNotEquals(1, gcd(polinom.getCoefsArray()));
    }

    //functions for checking primitiveness
    private static int gcd(double a, double b) {
        if (b == 0) {
            return (int) Math.abs(a);
        }
        return gcd(b, a % b);
    }

    private static int gcd(double... a) {
        int gcd = 0;
        for (int i = 0; i < a.length - 1; i++) {
            gcd = gcd(a[i], a[i + 1]);
        }
        return gcd;
    }
}