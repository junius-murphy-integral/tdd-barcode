package com.integral.barcode;

public class Display {
    static String lastDisplayedMessage;


    void displayPrice(String barcode)
    {
        lastDisplayedMessage = barcode;

        System.out.println(lastDisplayedMessage);
    }


    String getLastDisplayedPrice()
    {
        return lastDisplayedMessage;
    }
}
