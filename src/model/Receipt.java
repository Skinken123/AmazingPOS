package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.dto.ItemDTO;
import model.dto.ReceiptDTO;

/**
 * Represents a receipt for a sale, storing most improtant information about the sale.
 */
public class Receipt {
    private LocalTime saleTime;
    private double totalPrice;
    private double totalVAT;
    private double payment;
    private double change;
    private List<ItemDTO> currentItemList;

    /**
     * gets the total price of the sale.
     * @return the total price of the sale.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Sets the time of the sale.
     */
    public void setSaleTime(LocalTime saleTime) {
        this.saleTime = saleTime;
    }

    /**
     * Sets the total price of the sale.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Sets the total VAT of the sale.
     */
    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    /**
     * Sets the payment of the sale.
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Sets the change of the sale.
     */
    public void setChange(double change) {
        this.change = change;
    }

    /**
     * Sets the list of items in the sale.
     */
    public void setCurrentItemList(List<ItemDTO> currentItemList) {
        this.currentItemList = currentItemList;
    }

    /**
     * Updates the total price and total VAT of the sale as well as the itemList.
     * @param itemList The list of items in the sale.
     * @return The updated receiptDTO object with the newest information.
     */

    ReceiptDTO updateVATPriceList(List<ItemDTO> itemList){
        //antingen går den igenom alla element och räknar ut allt varje gång ett nytt item läggs till, 
        //eller så får metoden ett index med det nya itemet och räknar ut det nya priset etc och lägger till det. Då krävs get metoder för alla variabler i receipt.
        double totalPriceToSet = 0;
        double totalVATToSet = 0;
        for (ItemDTO item : itemList) {
            totalPriceToSet += item.getPrice() * item.getQuantity();
            totalVATToSet += item.getPrice() * item.getQuantity() * item.getTaxVAT();
        } 
        setTotalPrice(totalPriceToSet);
        setTotalVAT(totalVATToSet);
        setCurrentItemList(itemList);
        
        ReceiptDTO currentReceiptDTO = new ReceiptDTO(saleTime, totalPrice, totalVAT, payment, change, currentItemList);
        return currentReceiptDTO;
    }

    /**
     * Sets the sale time and payment of the sale.
     * @param payment The payment made by the customer.
     * @param change The change to be returned to the customer.
     * @return The final receiptDTO object with the newest information.
     */

    public ReceiptDTO setSaleTimeAndPayment(double payment, double change){
        setSaleTime(LocalTime.now());
        setPayment(payment);
        setChange(change);
        ReceiptDTO finalReceiptDTO = new ReceiptDTO(saleTime, totalPrice, totalVAT, payment, change, currentItemList);
        return finalReceiptDTO;
    }
}
