package integration;

public class ExternalSystemsCreator {
    ExternalAccountingSystem externalAS = new ExternalAccountingSystem();
    ExternalDiscountDatabase externalDD = new ExternalDiscountDatabase();
    ExternalInventorySystem externalIS = new ExternalInventorySystem();

    public ExternalAccountingSystem getExternalAS() {
        return externalAS;
    }
    public ExternalDiscountDatabase getExternalDD() {
        return externalDD;
    }
    public ExternalInventorySystem getExternalIS() {
        return externalIS;
    }
}
