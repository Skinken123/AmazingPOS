package controller;

import java.util.List;

import integration.ExternalAccountingSystem;
import integration.ExternalDiscountDatabase;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsCreator;
import integration.ReceiptPrinter;
import model.Sale;
import model.dto.ItemDTO;
import model.dto.ItemListDTO;
import model.dto.ReceiptDTO;


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

    /**
     * Enters an item to the current sale. This method must be called after a sale has been started.
     * Step 1: The item identifier is sent to the external inventory system to get the item data.
     * Step 2: The item data is used to create an ItemDTO object.
     * 
     * @param itemIdentifier The identifier of the item that is to be entered.
     * @param quantity The quantity of the item that is to be entered.
     * @return The DTO of the current receipt information after the item has been entered. 
     * The dto will be used by the view to display the updated sale infromation to the cashier and customer.
     */
    public ReceiptDTO enterNewItem(int itemIdentifier, int quantity){
        ItemDTO returnedItem = externalIS.requestItemData(itemIdentifier);
        ItemDTO newItem = new ItemDTO(returnedItem.getPrice(), returnedItem.getItemIdentifier(), returnedItem.getItemName(), returnedItem.getItemDescription(), returnedItem.getTaxVAT(), quantity);
        
        ReceiptDTO currenReceiptDTO = newSale.uppdateItemList(newItem);
        return currenReceiptDTO;
    }

    /**
     * Ends the current sale. This method must be called before payment.
     * 
     * @return The total price of the sale.
     */
    public double endSale() {
        return newSale.getTotalPrice();
    }

    /**
     * Sends the information of the sale to the external systems and prints the receipt.
     * 
     * @param payment The payment made by the customer.
     * @return The change that should be given to the customer.
     */
    public double payment(double amountPaid){
        double totalPrice = newSale.getTotalPrice();
        double change = amountPaid - totalPrice;
        ReceiptDTO finalReceiptDTO = newSale.getFinalReceiptDTO(amountPaid, change);
        externalAS.updateAccountingSystem(finalReceiptDTO);

        List<ItemDTO> finalItemList = newSale.getItemList();
        ItemListDTO finalItemListDTO = new ItemListDTO(finalItemList);
        externalIS.updateInventory(finalItemListDTO);
        return change;
    }
}
