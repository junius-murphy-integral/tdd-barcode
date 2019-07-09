package com.integral.barcode;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;

public class BarcodeScanner{

    BarcodeObserver observer;


    public void addObserver(BarcodeObserver barcodeObserver){
        observer = barcodeObserver;
    }

    public void setBarcode(String barcode){
        observer.update(barcode);
    }


}
