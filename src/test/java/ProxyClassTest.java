import model.Polinom;
import model.ProxyClass;
import model.interfaces.Polinomable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProxyClassTest {

    @Test
    public void proxyInstance(){
        Polinom polinom = new Polinom();
        Polinomable proxy = (Polinomable) ProxyClass.newProxyInstance(polinom);
        Assertions.assertEquals(polinom.getDegree(), proxy.getDegree());
    }

}