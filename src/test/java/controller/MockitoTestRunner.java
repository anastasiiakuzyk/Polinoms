package controller;

import model.Polinom;
import model.RationalPolinom;
import model.interfaces.Polinomable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTestRunner {

    @Mock
    private Polinomable polinomable;

    @InjectMocks
    private RationalPolinom rationalPolinom;

    @Test
    public void test() {
        rationalPolinom.getDenumeratorCoefs();
        verify(polinomable).getCoefsArray();
    }

    @Test
    public void simpleMocking() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        double[] coefs = {1.0d, 2.0d, 3.0d};
        rationalPolinom.setDenumerator(3, coefs);

        verify(denumerator).setCoefsArray(coefs);
        verify(denumerator).setX(3);
    }

    @Test
    public void ignoreParametr() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        rationalPolinom.setDenumerator(); //random

        verify(denumerator).setCoefsArrayRand(anyBoolean());
    }

    @Test
    public void stubParametrWhenThenReturn() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        when(denumerator.setX(eq(3.333))).thenReturn(4.444);
        assertEquals(4.444, rationalPolinom.setDenumerator(3.333));
    }

    @Test
    public void stubParametrDoReturnWhen() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        doReturn(2.222).when(denumerator).setX(5.436);
        assertEquals(2.222, rationalPolinom.setDenumerator(5.436));
    }

    @Test
    public void ignoreInput() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        when(denumerator.setX(anyDouble())).thenReturn(5.0);

        assertEquals(5.0, rationalPolinom.setDenumerator(4.0));
        assertEquals(5.0, rationalPolinom.setDenumerator(3.0));
    }


    @Test
    public void simpleVoidMocking() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        double[] coefs = {1, 2, 3};
        doNothing().when(denumerator).setCoefsArray(coefs);

        rationalPolinom.setDenumerator(3, coefs);
        verify(denumerator).setCoefsArray(coefs);
    }

    @Test
    public void voidTrows() {
        Polinomable denumerator = mock(Polinomable.class);
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        doThrow(new IllegalArgumentException("Degree can't be zero!")).when(denumerator).setDegree(0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rationalPolinom.setDenumeratorDegree(0);
        });
    }


    @Test
    public void testDevide() {
        Polinom mpol = mock(Polinom.class);
        when(mpol.getResult()).thenReturn(0.0);

        RationalPolinom rpol = new RationalPolinom();
        rpol.setDenumerator(mpol);

        assertThrows(IllegalArgumentException.class, rpol::getResult);
        verify(mpol).getResult();
        verifyNoMoreInteractions(mpol);

    }

    @Test
    public void testTimes() {
        RationalPolinom mpol = mock(RationalPolinom.class);
        mpol.setDenumerator(new Polinom());
        mpol.getResult();
        mpol.getResult();
        mpol.getResult();

        verify(mpol, times(3)).getResult();
    }
}