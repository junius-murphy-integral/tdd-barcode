package com.integral.barcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeObserverTests {

    @Test
    public void testStandardBarcodeFormat()
    {

        BarcodeObserver barcodeObserver = new BarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeObserver);
        barcodeScanner.setBarcode("1111111111111");

        assertEquals( "1111111111111", barcodeObserver.getLastBarcode());
    }

    @Test
    public void testStandardBarcodeFormatWithRealBarcode()
    {

        BarcodeObserver barcodeObserver = new BarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeObserver);
        barcodeScanner.setBarcode("9789332555402");

        assertEquals( "9789332555402", barcodeObserver.getLastBarcode());
    }
    @Test
    public void testBarcodeWithHyphens()
    {

        BarcodeObserver barcodeObserver = new BarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeObserver);
        barcodeScanner.setBarcode("978-93-325-5540-2");

        assertEquals( "9789332555402", barcodeObserver.getLastBarcode());
    }

    @Test
    public void testBarcodeWith12Digits()
    {

        BarcodeObserver barcodeObserver = new BarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeObserver);
        barcodeScanner.setBarcode("978933255540");

        assertEquals( "INVALID BARCODE", barcodeObserver.getLastBarcode());
    }

    @Test
    public void testBarcodeWithLetters()
    {
        BarcodeObserver barcodeObserver = new BarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.addObserver(barcodeObserver);
        barcodeScanner.setBarcode("978933255540A");

        assertEquals("INVALID BARCODE", barcodeObserver.getLastBarcode());
    }


}