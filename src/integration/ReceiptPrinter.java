package integration;

import model.dto.ReceiptDTO;

public class ReceiptPrinter {
    public void printReceipt(ReceiptDTO receipt) {
        System.out.println("Receipt: ");
        System.out.println("Sale time: " + receipt.getSaleTime());
        System.out.println("Total price: " + receipt.getTotalPrice());
        System.out.println("Total VAT: " + receipt.getTotalVAT());
        System.out.println("Payment: " + receipt.getPayment());
        System.out.println("Change: " + receipt.getChange());
        System.out.println("Items: ");
        for (String item : receipt.getBasicItemList()) {
            System.out.println(item);
        }
    }
}
