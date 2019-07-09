package com.integral.barcode;

public class StoreDisplay {
    static String lastDisplayedPrice;


    static void displayPrice(String barcode)
    {
        lastDisplayedPrice = barcode == "INVALID BARCODE"? barcode : BarcodePrices.catalog.get(barcode);
    }


    static String getLastDisplayedPrice()
    {
        return lastDisplayedPrice;
    }
}
