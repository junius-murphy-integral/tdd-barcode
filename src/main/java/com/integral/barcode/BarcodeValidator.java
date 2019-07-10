package com.integral.barcode;

public class BarcodeValidator {
    String barcode;
    private final String errorMessage = "INVALID BARCODE";
    public void update(String barcode){
        String strippedBarcode = barcode.replace("-", "");
        if(strippedBarcode.length() != 13 || !strippedBarcode.matches("[0-9]+"))
        {
            this.barcode = errorMessage;
        }
        else
        {
            this.barcode = strippedBarcode;
        }
        StoreDisplay.displayPrice(this.barcode);
    }
}
