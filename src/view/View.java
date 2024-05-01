package view;

import java.util.ResourceBundle.Control;

import controller.Controller;
import model.dto.ReceiptDTO;

/**
 * Represents the view of the program. This class represents the user interface which we will not code in this project.
 */

public class View {
    private Controller contr;

    /**
     * Creates a new instance of the view.
     * 
     * @param contr The controller that is used for all calls from the view.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution() {
        //behöver fixa så att utskriften blir bättre och att det går att lägga till flera items på ett bra sätt, lägg till en if sats och fler items i externalInventorySystem
        contr.startSale();
        System.out.println("A new sale has been started!");

        ReceiptDTO currReceiptDTO = contr.enterNewItem(1, 2);
        printReceipt(currReceiptDTO);
    }

    /**
     * Receipt information is printed to the console.
     */
    public void printReceipt(ReceiptDTO receiptDTO) {
        System.out.println("Receipt: ");
        System.out.println("Sale time: " + receiptDTO.getSaleTime());
        System.out.println("Total price: " + receiptDTO.getTotalPrice());
        System.out.println("Total VAT: " + receiptDTO.getTotalVAT());
        System.out.println("Payment: " + receiptDTO.getPayment());
        System.out.println("Change: " + receiptDTO.getChange());
        System.out.println("Items: ");
        for (String item : receiptDTO.getBasicItemList()) {
            System.out.println(item);
        }
    }
}
