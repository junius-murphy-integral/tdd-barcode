package com.integral.barcode;

public class Display {
    static String lastDisplayedPrice;


    void displayPrice(String barcode)
    {
        lastDisplayedPrice = barcode == "INVALID BARCODE"? barcode : BarcodePrices.barcodeByPrices.get(barcode);
        System.out.println(lastDisplayedPrice);
    }


    String getLastDisplayedPrice()
    {
        return lastDisplayedPrice;
    }
}
