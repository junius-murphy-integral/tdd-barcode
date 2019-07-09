package com.integral.barcode;

public class BarcodeObserver{
    String barcode;
    private String errorMessage = "INVALID BARCODE";
    public void update(String barcode){
        String strippedBarcode = barcode.replace("-", "");
        this.barcode = strippedBarcode.length() == 13? strippedBarcode : errorMessage;
        this.barcode = strippedBarcode.matches("[0-9]+")? strippedBarcode: errorMessage;
    }

        public String getLastBarcode(){
        return barcode;
    }
}
