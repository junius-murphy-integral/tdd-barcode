package com.integral.barcode;

public class StoreDisplay {
    static String lastDisplayedPrice;


    static void displayPrice(String barcode)
    {
        lastDisplayedPrice = BarcodePrices.catalog.get(barcode);
    }


    static String getLastDisplayedPrice()
    {
        return lastDisplayedPrice;
    }
}
