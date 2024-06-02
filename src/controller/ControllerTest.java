package controller;

import org.junit.jupiter.api.Test;

import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.ExternalSystemsCreator; 
import integration.ReceiptPrinter;
import model.Receipt;
import model.Sale;
import model.dto.ItemDTO;
import model.dto.ReceiptDTO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

/**
 * This is the class that will test all of the non constructor/get/set methods in the Controller class.
 */
public class ControllerTest {
    private Controller controller;  
    private ReceiptPrinter printer;
    private ExternalAccountingSystem externalAS;
    private ExternalInventorySystem externalIS;
    private Sale newSale;
    List<ItemDTO> itemList;

    /**
     * This method sets up the test class before each test method is run.
     */
    @BeforeEach
    public void setUp() {
        ExternalSystemsCreator creator = new ExternalSystemsCreator();
        printer = new ReceiptPrinter();
        externalAS = new ExternalAccountingSystem();
        externalIS = new ExternalInventorySystem();
        itemList = new ArrayList<>();
        controller = new Controller(creator, printer);
    }  

    /**
     * This method tests the startSale method in the Controller class to make sure that the method returns what is expected from a certain input. 
     */
    @Test
    public void testEnterNewItem() {
        controller.startSale();
        ItemDTO item = new ItemDTO(35, 1, "Tomato", "A box of red tomatos", 0.12, 1);
        itemList.add(item);
        ReceiptDTO result = controller.enterNewItem(1); 
        ReceiptDTO expected = new ReceiptDTO(null, 35.0, 4.2, 0, 0, itemList);

        assertTrue(result.getTotalPrice() == expected.getTotalPrice(), "The total price is not the same");
        assertTrue(result.getTotalVAT() == expected.getTotalVAT(), "The total VAT is not the same");
        assertTrue(result.getPayment() == expected.getPayment(), "The payment is not the same");
        assertTrue(result.getChange() == expected.getChange(), "The change is not the same");
        compareLists(result.getCurrentItemList(), expected.getCurrentItemList());
    }

    /**
     * This method tests the endSale method in the Controller class to make sure that the method returns what is expected from a certain input.  
     */
    @Test
    public void testEndSale() {
        controller.startSale();
        controller.enterNewItem(1);
        controller.enterNewItem(2);
        controller.enterNewItem(3);
        double result = controller.endSale();
        double expected = (35.0+22.5+36.90);
        assertTrue(result == expected, "The total price is not the same");
    }

    /**
     * This method tests the payment method in the Controller class to make sure that the method returns what is expected from a certain input. 
     */
    @Test
    public void testPayment(){
        controller.startSale();
        controller.enterNewItem(1);
        controller.enterNewItem(2);
        controller.enterNewItem(3);

        ItemDTO firstItem = new ItemDTO(35, 1, "Tomato", "A box of red tomatos", 0.12, 1);
        ItemDTO secondItem = new ItemDTO(22.5, 2, "Bread", "A loaf of Pågenslimpa", 0.12, 1);
        ItemDTO thirdItem = new ItemDTO(36.90, 3, "Steak", "A a premium oxfile produced in Sweden", 0.12, 1);
        itemList.add(firstItem);
        itemList.add(secondItem);
        itemList.add(thirdItem);

        ReceiptDTO result = controller.payment(500);
        ReceiptDTO expected = new ReceiptDTO(null, 94.4, 11.328, 500, 405.6, itemList);

        assertTrue(result.getTotalPrice() == expected.getTotalPrice(), "The total price is not the same");
        assertTrue(result.getTotalVAT() == expected.getTotalVAT(), "The total VAT is not the same");
        assertTrue(result.getPayment() == expected.getPayment(), "The payment is not the same");
        assertTrue(result.getChange() == expected.getChange(), "The change is not the same");
        compareLists(result.getCurrentItemList(), expected.getCurrentItemList());
    }

    /**
     * This method resets the test class after each test method is run.
     */
    @AfterEach
    public void tearDown() {
        controller = null;
        printer = null;
        externalAS = null;
        externalIS = null;
        newSale = null;
        itemList = null;
    }

    /**
     * This method compares two lists of ItemDTO objects.
     * It compares the size of the lists and then compares each individual object in the list.
     * If the lists are not the same it will fail the test.
     * @param result The list of ItemDTO objects that is the result of the method.
     * @param expected The list of ItemDTO objects that is the expected result of the method.
     */
    void compareLists(List<ItemDTO> result, List<ItemDTO> expected) {
        if (result.size() != expected.size()) {
            fail("The item list is not the same");
        }
        else{
            for (int i = 0; i < result.size(); i++) {
                System.out.println(i + "\n");
                assertTrue(result.get(i).equals(expected.get(i)), "The item list is not the same");
            }
        }
    }
}
