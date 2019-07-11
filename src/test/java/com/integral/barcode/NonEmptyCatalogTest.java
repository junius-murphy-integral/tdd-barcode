package com.integral.barcode;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

public class NonEmptyCatalogTest {

    private Display display;
    private Sale sale;


    @Before
    public void setUp() throws Exception{
        display = new Display();
        sale = new Sale(display, new Catalog(new HashMap<String, String>() {{
            put("1111111111111", "1.11");
            put("9789332555402", "9.99");
            put("2222222222222", "2.22");
            put("3333333333333", "3.33");
        }}));
    }


    @Test
    public void testStandardBarcodeFormat()
    {
        String barcode = "1111111111111";
        sale.onBarcode(barcode);
        assertEquals( "$1.11", sale.getDisplay().getLastDisplayedMessage());

    }

    @Test
    public void testStandardBarcodeFormatWithRealBarcode()
    {
        String barcode = "9789332555402";
        sale.onBarcode(barcode);
        assertEquals("$9.99" , sale.getDisplay().getLastDisplayedMessage());
    }
    @Test
    public void testBarcodeWithHyphens()
    {
        String originalBarcode = "978-93-325-5540-2";
        sale.onBarcode(originalBarcode);
        assertEquals( "$9.99", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testValidBarcodeThatDoesNotExistsInCatalog()
    {
        sale.onBarcode("1212121212121");
        assertEquals( "Barcode does not exist in catalog", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBuyingThreeItems()
    {
        sale.onBarcode("1111111111111");
        sale.onBarcode("2222222222222");
        sale.onBarcode("3333333333333");
        sale.endSale();
        assertEquals( "$6.66", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBuyingThreeItemsWhereOneItemIsNotInCatalog(){
        sale.onBarcode("1111111111111");
        sale.onBarcode("3333333333333");
        sale.onBarcode("5555555555555");
        sale.endSale();
        assertEquals("$4.44", sale.getDisplay().getLastDisplayedMessage());
    }

}