package controller;

import interfaces.Model;
import interfaces.View;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ControllerTestRefl {

    @Mock
    private Model model;

    @Mock
    private View view;

    @InjectMocks
    private Controller controller;

    @Test
    public void testControllerProcessingGettingSuperClassName() {
        doReturn("get superclass").when(view).ask("Choose variant: ");
        controller.processReflexion();
        verify(model, times(1)).getSuperClassSimpleName();
    }

    @Test
    public void testControllerProcessingGettingClassName() {
        doReturn("get class").when(view).ask("Choose variant: ");
        controller.processReflexion();
        verify(model, times(1)).getClassSimpleName();
    }

    @Test
    public void testControllerProcessingGettingClassPackage() {
        doReturn("get package").when(view).ask("Choose variant: ");
        controller.processReflexion();
        verify(model, times(1)).getPackageName();
    }

    @Test
    public void testControllerProcessingGettingMethodsInfo() {
        doReturn("get methods").when(view).ask("Choose variant: ");
        controller.processReflexion();
        verify(model, times(1)).getMethodInfo();
    }

    @Test
    public void testControllerProcessingInvokingMethods() {
        doReturn("invoke methods").when(view).ask("Choose variant: ");
        controller.processReflexion();
        verify(model, times(1)).listOfAnnotations();
    }
}
