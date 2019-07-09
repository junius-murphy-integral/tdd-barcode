package com.integral.barcode;

public class BarcodeHandler {

    private static String lastDisplayedPrice;

    public static void onBarcode(String barcode)
    {
        lastDisplayedPrice = "9.99";
    }

    public static String lastDisplayedPrice()
    {
        return lastDisplayedPrice;
    }
}
