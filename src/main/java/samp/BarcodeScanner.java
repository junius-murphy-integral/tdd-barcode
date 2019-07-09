package samp;

import java.util.ArrayList;
import java.util.List;

public class BarcodeScanner {

    private static String lastValue;

    List<BarcodeObserver> observers = new ArrayList<>();

    public void subscribe(BarcodeObserver barcodeObserver) {
        observers.add(barcodeObserver);
    }

    public void useBarcode(String barcode) {
        lastValue = barcode;
        observers.forEach(barcodeObserver -> barcodeObserver.onBarcode(barcode));
    }

    public String getLastValue() {
        return lastValue;
    }

}
