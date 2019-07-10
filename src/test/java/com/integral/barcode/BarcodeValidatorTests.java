package com.integral.barcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeValidatorTests {

    @Test
    public void testStandardBarcodeFormat()
    {
        String barcode = "1111111111111";
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode(barcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(barcode), StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testStandardBarcodeFormatWithRealBarcode()
    {
        String barcode = "9789332555402";
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode(barcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(barcode), StoreDisplay.getLastDisplayedPrice());
    }
    @Test
    public void testBarcodeWithHyphens()
    {
        String originalBarcode = "978-93-325-5540-2";
        String expectedBarcode = "9789332555402";

        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode(originalBarcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(expectedBarcode), StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWith12Digits()
    {

        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode("978933255540");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWithLetters()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode("978933255540A");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }


    @Test
    public void testEmptyBarcode()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode("");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWithRandomCharacters()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        Sale sale = new Sale();

        sale.addObserver(barcodeValidator);
        sale.setBarcode("$&%^*#($*%&-_");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

}