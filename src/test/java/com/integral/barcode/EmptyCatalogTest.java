package com.integral.barcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class EmptyCatalogTest {

    private Display display;
    private Sale sale;


    @Before
    public void setUp() throws Exception{
        display = new Display();
        sale = new Sale(display, new Catalog(Collections.emptyMap()));
    }

    @Test
    public void testBarcodeWith12Digits()
    {
        sale = new Sale(display, new Catalog(Collections.emptyMap()));
        sale.onBarcode("978933255540");
        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBarcodeWithLetters()
    {
        sale = new Sale(display, new Catalog(Collections.emptyMap()));
        sale.onBarcode("978933255540A");
        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }


    @Test
    public void testEmptyBarcode()
    {
        sale = new Sale(display, new Catalog(Collections.emptyMap()));
        sale.onBarcode("");
        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }

    @Test
    public void testBarcodeWithRandomCharacters()
    {
        sale = new Sale(display, new Catalog(Collections.emptyMap()));
        sale.onBarcode("$&%^*#($*%&-_");
        assertEquals( "INVALID BARCODE", sale.getDisplay().getLastDisplayedMessage());
    }
}
