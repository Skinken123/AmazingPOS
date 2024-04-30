package controller;

import integration.ExternalAccountingSystem;
import integration.ExternalDiscountDatabase;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsCreator;
import integration.ReceiptPrinter;

public class Controller {
    private ReceiptPrinter printer;
    private ExternalAccountingSystem externalAS;
    private ExternalDiscountDatabase externalDD;
    private ExternalInventorySystem externalIS;

    public Controller(ExternalSystemsCreator creator, ReceiptPrinter printer) {
        this.printer = printer;
        this.externalAS = creator.getExternalAS();
        this.externalDD = creator.getExternalDD();
        this.externalIS = creator.getExternalIS();
    }

}
