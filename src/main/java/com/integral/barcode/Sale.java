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
        String strippedBarcode = barcode.replace("-", "");
        if(strippedBarcode.length() != 13 || !strippedBarcode.matches("[0-9]+"))
        {
            barcode = "INVALID BARCODE";
        }
        else if(!this.barcodeByPrices.containsKey(strippedBarcode)){
            barcode = "Barcode does not exist in catalog";
        }
        else
        {
            barcode = strippedBarcode;
            this.display.displayPrice(barcodeByPrices.get(barcode));
            return;
        }
        this.display.displayPrice(barcode);
    }

    public Display getDisplay(){
        return this.display;
    }


}
