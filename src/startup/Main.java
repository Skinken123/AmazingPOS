package startup;

import java.util.ResourceBundle.Control;

import view.View;
import controller.Controller;
import integration.ExternalSystemsCreator;
import integration.ReceiptPrinter;

/**
 * Contains the <code>main</code> method. Performs all startup of the application.
 */

public class Main { 
    /**
     * Starts the application.
     * 
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        ExternalSystemsCreator creator = new ExternalSystemsCreator();
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller contr = new Controller(creator, printer);
        View view = new View(contr);
        view.sampleExecution();
    }
}
