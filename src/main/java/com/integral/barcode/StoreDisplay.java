package com.integral.barcode;

public class StoreDisplay {
    static String lastDisplayedPrice;


    static void displayPrice(String barcode)
    {
        lastDisplayedPrice = barcode == "INVALID BARCODE"? barcode : BarcodePrices.barcodeByPrices.get(barcode);
        System.out.println(lastDisplayedPrice);
    }


    static String getLastDisplayedPrice()
    {
        return lastDisplayedPrice;
    }
}
