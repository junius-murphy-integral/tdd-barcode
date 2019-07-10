package com.integral.barcode;

public class Sale {

    BarcodeValidator observer;


    public void addObserver(BarcodeValidator barcodeValidator){
        observer = barcodeValidator;
    }

    public void setBarcode(String barcode){
        observer.update(barcode);
    }


}