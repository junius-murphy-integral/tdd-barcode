package com.integral.barcode;

public class Sale {

    BarcodeValidator observer;


    public void addObserver(BarcodeValidator barcodeValidator){
        observer = barcodeValidator;
    }

    public void onBarcode(String barcode){
        observer.update(barcode);
    }


}
