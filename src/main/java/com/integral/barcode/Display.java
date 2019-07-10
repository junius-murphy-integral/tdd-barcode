package com.integral.barcode;

public class Display {
    static String lastDisplayedMessage;


    void displayMessage(String barcode)
    {
        lastDisplayedMessage = barcode;

        System.out.println(lastDisplayedMessage);
    }


    String getLastDisplayedMessage()
    {
        return lastDisplayedMessage;
    }
}
