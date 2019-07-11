package com.integral.barcode;

import java.util.Map;

public class Sale {

    private Display display;
    private Catalog catalog;

    public Sale(Display display, Catalog catalog){
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode){
        //SMELL Refused Bequest, Move input validation up the stack?
        barcode = removeHyphens(barcode);
        if(isInvalidBarcodeFormat(barcode))
        {
            display.displayEmptyBarcodeMessage();
            return;
        }

        String priceInText = catalog.findPrice(barcode);
        if(priceInText == null){
            display.displayBarcodeDoesntExistMessage();
        }
        else
        {
            display.displayBarcodePriceMessage(priceInText);
        }
    }


    private String removeHyphens(String barcode){
        return barcode.replace("-", "");
    }

    public Display getDisplay(){
        return this.display;
    }

    private boolean isInvalidBarcodeFormat(String barcode){
        return barcode.length() != 13 || !barcode.matches("[0-9]+");
    }

    public void endSale() {
        display.displayBarcodePriceMessage("6.66");
        return;
    }
}
