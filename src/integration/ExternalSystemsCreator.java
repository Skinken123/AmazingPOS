package integration;

public class ExternalSystemsCreator {
    ExternalAccountingSystem externalAS = new ExternalAccountingSystem();
    ExternalDiscountDatabase externalDD = new ExternalDiscountDatabase();
    ExternalInventorySystem externalIS = new ExternalInventorySystem();

    /**
     * Gets the external accounting system.
     * @return returns an object resposible for communication with the external accounting system.
     */
    public ExternalAccountingSystem getExternalAS() {
        return externalAS;
    }
    /**
     * Gets the external discount database.
     * @return returns an object resposible for communication with the external discount database.
     */
    public ExternalDiscountDatabase getExternalDD() {
        return externalDD;
    }
    /**
     * Gets the external inventory system.
     * @return returns an object resposible for communication with the external inventory system.
     */
    public ExternalInventorySystem getExternalIS() {
        return externalIS;
    }
}
