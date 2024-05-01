package model;

/**
 * Represents a sale, the primary job of this class is to store the items being bought in the sale.
 */
public class Sale {
    private Receipt newReceipt;
    //private List<ItemDTO> itemList;

    /**
     * Creates a new instance of a sale and creates a instance of the receipt when a new sale is started.
     */
    public Sale() {
        newReceipt = new Receipt();
    }
}
