package com.integral.barcode;

public class BarcodeObserver{
    String barcode;
    public void update(String barcode){
        this.barcode = barcode.replace("-", "");
    }

        public String getLastBarcode(){
        return barcode;
    }
}
