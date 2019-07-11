package com.integral.barcode;

public class Sale {

    private Display display;
    private Catalog catalog;
    private String currentSaleTotalInText = "0";

    public Sale(Display display, Catalog catalog){
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode){
        //SMELL Refused Bequest, Move input validation up the stack?
        barcode = removeHyphens(barcode);
        if(isInvalidBarcodeFormat(barcode))
        {
            display.displayEmptyBarcodeMessage();
            return;
        }


        String newItemPrice = catalog.findPrice(barcode);
        if(newItemPrice == null){
            display.displayBarcodeDoesntExistMessage();
        }
        else
        {
            Float currentSaleTotal = (Float.parseFloat(currentSaleTotalInText) + Float.parseFloat(newItemPrice));
            currentSaleTotalInText = currentSaleTotal.toString();
        }
    }


    private String removeHyphens(String barcode){
        return barcode.replace("-", "");
    }

    public Display getDisplay(){
        return this.display;
    }

    private boolean isInvalidBarcodeFormat(String barcode){
        return barcode.length() != 13 || !barcode.matches("[0-9]+");
    }

    public void endSale() {
        display.displayBarcodePriceMessage(currentSaleTotalInText);
        return;
    }
}
