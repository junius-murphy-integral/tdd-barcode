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
        //SMELL Move input validation up the stack?
        barcode = barcode.replace("-", "");
        String message;
        if(isInvalidBarcodeFormat(barcode))
        {
            message = "INVALID BARCODE";
        }
        else if(!this.barcodeByPrices.containsKey(barcode)){
            message = "Barcode does not exist in catalog";
        }
        else
        {
            message = barcodeByPrices.get(barcode);
        }
        this.display.displayMessage(message);
    }

    public Display getDisplay(){
        return this.display;
    }

    private boolean isInvalidBarcodeFormat(String barcode){
        return barcode.length() != 13 || !barcode.matches("[0-9]+");
    }

}
