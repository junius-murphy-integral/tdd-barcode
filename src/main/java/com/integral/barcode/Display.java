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

    public void displayBarcodePriceMessage(String priceInText) {
        displayMessage(priceInText);
    }

    public void displayEmptyBarcodeMessage() {
        String message = "INVALID BARCODE";
        displayMessage(message);
    }

    public void displayBarcodeDoesntExistMessage() {
       String message = "Barcode does not exist in catalog";
        displayMessage(message);
    }
}
