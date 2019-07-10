package com.integral.barcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeValidatorTests {

    @Test
    public void testStandardBarcodeFormat()
    {
        String barcode = "1111111111111";
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode(barcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(barcode), StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testStandardBarcodeFormatWithRealBarcode()
    {
        String barcode = "9789332555402";
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode(barcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(barcode), StoreDisplay.getLastDisplayedPrice());
    }
    @Test
    public void testBarcodeWithHyphens()
    {
        String originalBarcode = "978-93-325-5540-2";
        String expectedBarcode = "9789332555402";

        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode(originalBarcode);

        assertEquals( BarcodePrices.barcodeByPrices.get(expectedBarcode), StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWith12Digits()
    {

        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode("978933255540");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWithLetters()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode("978933255540A");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }


    @Test
    public void testEmptyBarcode()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode("");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

    @Test
    public void testBarcodeWithRandomCharacters()
    {
        BarcodeValidator barcodeValidator = new BarcodeValidator();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeValidator);
        barcodeScanner.setBarcode("$&%^*#($*%&-_");

        assertEquals( "INVALID BARCODE", StoreDisplay.getLastDisplayedPrice());
    }

}