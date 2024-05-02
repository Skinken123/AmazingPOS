package model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import model.dto.ItemDTO;
import model.dto.ReceiptDTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class SaleTest {
    private Sale sale;
    private Receipt receipt;
    private List<ItemDTO> itemList;
    private LocalTime saleTime;
    private double payment;
    private double change;

    @BeforeEach
    public void setUp() {
        receipt = new Receipt();
        itemList = new ArrayList<>();
        sale = new Sale();
        saleTime = null;
    }

    @Test
    public void testUppdateItemList() {
        ItemDTO item = new ItemDTO(10, 1, "Milk", "1L", 0.12, 1);
        itemList.add(item);
        ReceiptDTO result = sale.uppdateItemList(item);
        ReceiptDTO expected = new ReceiptDTO(saleTime, 10.0, 1.2, payment, change, itemList);
         
        double resPrice = result.getTotalPrice();
        double expPrice = expected.getTotalPrice();
        assertTrue(resPrice == expPrice, "The total price is not the same");

        double resVAT = result.getTotalVAT();
        double expVAT = expected.getTotalVAT();
        assertTrue(resVAT == expVAT, "The total VAT is not the same");

        double resPayment = result.getPayment();
        double expPayment = expected.getPayment();
        assertTrue(resPayment == expPayment, "The payment is not the same");

        double resChange = result.getChange();
        double expChange = expected.getChange();
        assertTrue(resChange == expChange, "The change is not the same");

        LocalTime resTime = result.getSaleTime();
        LocalTime expTime = expected.getSaleTime();
        assertTrue(resTime == expTime, "The sale time is not the same");

        List<ItemDTO> resItemList = result.getCurrentItemList();
        List<ItemDTO> expItemList = expected.getCurrentItemList();
        assertTrue(resItemList.equals(expItemList), "The item list is not the same");
        
    }

    @AfterEach
    public void tearDown() {
        sale = null;
        receipt = null;
        itemList = null;
        saleTime = null;
    }
}
