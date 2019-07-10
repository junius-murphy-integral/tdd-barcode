package com.integral.barcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BarcodeValidatorTests {

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
        assertEquals( "$1.11", sale.getDisplay().getLastDisplayedPrice());

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

        assertEquals( BarcodePrices.barcodeByPrices.get(barcode), sale.getDisplay().getLastDisplayedPrice());
    }
//    @Test
//    public void testBarcodeWithHyphens()
//    {
//        String originalBarcode = "978-93-325-5540-2";
//        String expectedBarcode = "9789332555402";
//
//        BarcodeValidator barcodeValidator = new BarcodeValidator();
//        Sale sale = new Sale();
//
//        sale.addObserver(barcodeValidator);
//        sale.onBarcode(originalBarcode);
//
//        assertEquals( BarcodePrices.barcodeByPrices.get(expectedBarcode), Display.getLastDisplayedPrice());
//    }
//
//    @Test
//    public void testBarcodeWith12Digits()
//    {
//
//        BarcodeValidator barcodeValidator = new BarcodeValidator();
//        Sale sale = new Sale();
//
//        sale.addObserver(barcodeValidator);
//        sale.onBarcode("978933255540");
//
//        assertEquals( "INVALID BARCODE", Display.getLastDisplayedPrice());
//    }
//
//    @Test
//    public void testBarcodeWithLetters()
//    {
//        BarcodeValidator barcodeValidator = new BarcodeValidator();
//        Sale sale = new Sale();
//
//        sale.addObserver(barcodeValidator);
//        sale.onBarcode("978933255540A");
//
//        assertEquals( "INVALID BARCODE", Display.getLastDisplayedPrice());
//    }
//
//
//    @Test
//    public void testEmptyBarcode()
//    {
//        BarcodeValidator barcodeValidator = new BarcodeValidator();
//        Sale sale = new Sale();
//
//        sale.addObserver(barcodeValidator);
//        sale.onBarcode("");
//
//        assertEquals( "INVALID BARCODE", Display.getLastDisplayedPrice());
//    }
//
//    @Test
//    public void testBarcodeWithRandomCharacters()
//    {
//        BarcodeValidator barcodeValidator = new BarcodeValidator();
//        Sale sale = new Sale();
//
//        sale.addObserver(barcodeValidator);
//        sale.onBarcode("$&%^*#($*%&-_");
//
//        assertEquals( "INVALID BARCODE", Display.getLastDisplayedPrice());
//    }
//
}