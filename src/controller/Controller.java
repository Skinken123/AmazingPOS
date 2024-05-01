package controller;

import integration.ExternalAccountingSystem;
import integration.ExternalDiscountDatabase;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsCreator;
import integration.ReceiptPrinter;
import model.Sale;


/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class Controller {
    private ReceiptPrinter printer;
    private ExternalAccountingSystem externalAS;
    private ExternalDiscountDatabase externalDD;
    private ExternalInventorySystem externalIS;
    private Sale newSale;

    /**
     * Creates a new instance of the controller.
     * 
     * @param creator The creator of the external systems.
     * @param printer The printer that will print the receipt.
     */
    public Controller(ExternalSystemsCreator creator, ReceiptPrinter printer) {
        this.printer = printer;
        this.externalAS = creator.getExternalAS();
        this.externalDD = creator.getExternalDD();
        this.externalIS = creator.getExternalIS();
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */

    public void startSale() {
        newSale = new Sale();
    }

}
