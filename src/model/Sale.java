package model;

import java.util.ArrayList;
import java.util.List;

import model.dto.ItemDTO;
import model.dto.ReceiptDTO;

/**
 * Represents a sale, the primary job of this class is to store the items being bought in the sale.
 */
public class Sale {
    private Receipt newReceipt;
    private List<ItemDTO> itemList = new ArrayList<>();

    /**
     * Creates a new instance of a sale and creates a instance of the receipt when a new sale is started.
     */
    public Sale() {
        newReceipt = new Receipt();
    }

    /**
     * Adds an item to the sale. If the item already exists in the sale, the quantity of the item will be increased.
     * 
     * @param item The item to be added to the sale.
     */
    public ReceiptDTO uppdateItemList(ItemDTO newItem) {
        boolean itemExists = false;
        for (ItemDTO item : itemList) {
            if (item.getItemName() == newItem.getItemName()) {
                ItemDTO updatedItem = new ItemDTO(item.getPrice(), item.getItemIdentifier(), item.getItemName(), item.getItemDescription(), item.getTaxVAT(), item.getQuantity() + newItem.getQuantity());
                itemList.remove(item); 
                itemList.add(updatedItem);
            }
        }
        if (!itemExists) {
            itemList.add(newItem);
        }
        ReceiptDTO currenReceiptDTO = newReceipt.updateVATPriceList(itemList);
        return currenReceiptDTO;
    }
}
