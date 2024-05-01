package integration;

import model.dto.ItemDTO;
import model.dto.ItemListDTO;

/**
 * Represents a class which will communicate with the actual inventory system.
 */

public class ExternalInventorySystem {
    /**
     * takes an itemIdentifier and returns the item data for that item. 
     * There is no implementation regarding if the itemIdentifier is invalid since this is not requierd in this seminar.
     * We will hence asume the item identifier is always valid and return an item. Since we do not have a database we will just return a hardcoded item to test the program. 
     * @param itemIdentifier The identifier of the item scanned by the cashier.
     */
    public ItemDTO requestItemData(int itemIdentifier) {
        //some code that fetches the item data from the inventory system
        return new ItemDTO(10, itemIdentifier, "Milk", "A carton of milk", 0.12, 1);
    }

    /**
     * Updates the inventory system with the information of the sale.
     * @param itemDTO The itemDTO object that contains the information of the item that was sold.
     */
    public void updateInventory(ItemListDTO itemListDTO) {
        //some code that updates the inventory system
        System.out.println("The inventory has been updated");
    }
        
}
