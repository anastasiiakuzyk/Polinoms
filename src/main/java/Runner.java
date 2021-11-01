import controller.Controller;
import interfaces.Model;
import model.Polinom;
import view.View;

public class Runner {
    public static void main(String[] args) {
        Model model = new Polinom();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUserInput();
    }
}
