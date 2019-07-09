package com.integral.barcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeHandlerTest {

    @Test
    public void testStandardBarcodeFormatReturnsPrice()
    {
        BarcodeHandler.onBarcode("978-93-325-5540-2");
        assertEquals(BarcodeHandler.lastDisplayedPrice(), "9.99");
    }

}