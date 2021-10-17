package mock;

import interfaces.Model;
import model.Polinom;
import org.junit.jupiter.api.Test;
import view.View;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    void processModel() throws Exception {
        Model polinom = mock(Polinom.class);
        View view = mock(View.class);
        Controller controller = new Controller(polinom, view);
        when(polinom.getResult()).thenReturn(4.0);

        assertEquals(4.0, controller.processModel());

        verify(polinom).getResult();
    }


    @Test
    public void checkTimes() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        when(view.ask(matches("Choose*"))).thenReturn("get superclass");

        controller.processReflexion();
        controller.processReflexion();
        controller.processReflexion();
        controller.processReflexion();

        verify(view, times(4)).printMenu();
        verify(view, atLeastOnce()).ask(anyString());
        verify(view, never()).askCoefs();
    }

    @Test
    public void zeroInteractions() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        verifyNoInteractions(view, model);
    }


    @Test
    public void parametrEndsWith() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        when(view.ask(endsWith("you?"))).thenReturn("Bye");

        assertEquals("Bye", controller.invite());
    }

    @Test
    public void parametrContains() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        when(view.ask(contains("how"))).thenReturn("Bye");

        assertEquals("Bye", controller.invite());
    }

    @Test
    public void parametrStartsWith() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        when(view.ask(startsWith("He"))).thenReturn("Bye");

        assertEquals("Bye", controller.invite());
    }

    @Test
    public void scenarioMatches() {
        interfaces.View view = mock(interfaces.View.class);
        Model model = mock(Model.class);
        Controller controller = new Controller(model, view);

        when(view.ask(matches("Choose*"))).thenReturn("get superclass");

        controller.processReflexion();

        verify(model).getSuperClassSimpleName();
    }

}
