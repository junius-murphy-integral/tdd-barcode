package com.integral.barcode;

import java.util.Map;

public class Sale {

    private Map<String, String> barcodeByPrices;
    private Display display;

    public Sale(Display display,Map<String, String> catalog){
        this.barcodeByPrices = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode){
        //SMELL Refused Bequest, Move input validation up the stack?
        barcode = removeHyphens(barcode);
        if(isInvalidBarcodeFormat(barcode))
        {
            displayEmptyBarcodeMessage();
            return;
        }

        String priceInText = findPrice(barcode);
        if(priceInText == null){
            displayBarcodeDoesntExistMessage();
        }
        else
        {
            displayBarcodePriceMessage(priceInText);
        }
    }


    private String removeHyphens(String barcode){
        return barcode.replace("-", "");
    }
    private String findPrice(String barcode){
        return barcodeByPrices.get(barcode);
    }

    private void displayBarcodePriceMessage(String priceInText) {
        this.display.displayMessage(priceInText);
    }

    private void displayBarcodeDoesntExistMessage() {
       String message = "Barcode does not exist in catalog";
        this.display.displayMessage(message);
    }

    private void displayEmptyBarcodeMessage() {
        String message = "INVALID BARCODE";
        this.display.displayMessage(message);
    }

    public Display getDisplay(){
        return this.display;
    }

    private boolean isInvalidBarcodeFormat(String barcode){
        return barcode.length() != 13 || !barcode.matches("[0-9]+");
    }

}
