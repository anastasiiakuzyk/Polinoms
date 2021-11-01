package controller;

import model.Polinom;
import model.RationalPolinom;
import model.interfaces.Polinomable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RealClassTest {

    @Test
    void spyParameter() {
        Polinomable denumerator = spy(new Polinom(1, 3));
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);
        assertEquals(1, rationalPolinom.getDenumerator().getX());
        when(denumerator.setX(1)).thenReturn(2.0);

        //same
        doReturn(2.0).when(denumerator).setX(1.0);

        assertEquals(2.0, rationalPolinom.setDenumerator(1.0));
    }

    @Test
    void stubThanCall() {
        Polinomable denumerator = mock(Polinom.class); // class
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);
        when(denumerator.setX(5)).thenReturn(6.0).thenCallRealMethod();

        assertEquals(6.0, rationalPolinom.setDenumerator(5.0));
    }

    @Test
    void voidCallRealMothod() {
        Polinomable denumerator = mock(Polinom.class); // class
        RationalPolinom rationalPolinom = new RationalPolinom(denumerator);

        double[] coefs = {3, 4, 5};
        doCallRealMethod().when(denumerator).setCoefsArray(coefs);

        rationalPolinom.setDenumerator(1, coefs);
        verify(denumerator).setCoefsArray(coefs);
    }
}
