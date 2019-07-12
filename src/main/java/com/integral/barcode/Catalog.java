package com.integral.barcode;

import java.util.Map;

public class Catalog {
    private final Map<String, String> barcodeByPrices;

    public Catalog(Map<String, String> barcodeByPrices) {
        this.barcodeByPrices = barcodeByPrices;
    }

    public String findPrice(String barcode){
        return barcodeByPrices.get(barcode);
    }
}
