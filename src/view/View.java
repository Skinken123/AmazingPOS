package view;

import java.util.ResourceBundle.Control;

import controller.Controller;

/**
 * Represents the view of the program. This class represents the user interface which we will not code in this project.
 */

public class View {
    private Controller contr;

    /**
     * Creates a new instance of the view.
     * 
     * @param contr The controller that is used for all calls from the view.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution() {
        contr.startSale();
        System.out.println("A new sale has been started!");
    }
}
