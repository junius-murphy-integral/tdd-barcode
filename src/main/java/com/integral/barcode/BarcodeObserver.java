package com.integral.barcode;

public class BarcodeObserver{
    String barcode;
    public void update(String barcode){
        String strippedBarcode = barcode.replace("-", "");
        this.barcode = strippedBarcode.length() == 13? strippedBarcode : "INVALID BARCODE";
    }

        public String getLastBarcode(){
        return barcode;
    }
}
