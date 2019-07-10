package com.integral.barcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SellOneItemTest {

    @Test
    public void testStandardBarcodeFormat()
    {
        String barcode = "1111111111111";
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode(barcode);
        assertEquals( "$1.11", sale.getDisplay().getLastDisplayedMessage());

    }

    @Test
    public void testStandardBarcodeFormatWithRealBarcode()
    {
        String barcode = "9789332555402";
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode(barcode);

        assertEquals("$9.99" , sale.getDisplay().getLastDisplayedMessage());
    }
    @Test
    public void testBarcodeWithHyphens()
    {
        String originalBarcode = "978-93-325-5540-2";


        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode(originalBarcode);

        assertEquals( "$9.99", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBarcodeWith12Digits()
    {

        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("978933255540");

        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBarcodeWithLetters()
    {
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("978933255540A");

        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }


    @Test
    public void testEmptyBarcode()
    {
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("");

        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBarcodeWithRandomCharacters()
    {
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("$&%^*#($*%&-_");

        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testValidBarcodeThatDoesNotExistsInCatalog()
    {
        Map<String, String> catalog = new HashMap<String, String>() {{
            put("1111111111111", "$1.11");
            put("9789332555402", "$9.99");
            put("2222222222222", "$2.22");
            put("3333333333333", "$3.33");
        }};
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("1212121212121");

        assertEquals( "Barcode does not exist in catalog", sale.getDisplay().getLastDisplayedMessage());
    }

}