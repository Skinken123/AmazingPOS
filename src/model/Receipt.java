package model;

import java.time.LocalTime;
import java.util.List;

/**
 * Represents a receipt for a sale, storing most improtant information about the sale.
 */
public class Receipt {
    private LocalTime saleTime;
    private double totalPrice;
    private double totalVAT;
    private double payment;
    private double change;
    private List<String> basicItemList;
}
