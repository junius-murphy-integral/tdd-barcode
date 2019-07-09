package samp;

import org.junit.Test;

public class BarcodeScannerTest {

    public class TestBarcodeObserver implements BarcodeObserver {

        @Override
        public void onBarcode(String code) {
            System.out.println("TestBarcodeObserver received the thing!: " + code);
        }
    }


    @Test
    public void name() {
        TestBarcodeObserver myObserver = new TestBarcodeObserver();
        BarcodeScanner barcodeScanner = new BarcodeScanner();

        barcodeScanner.subscribe(myObserver);

        barcodeScanner.useBarcode("21564894894");
    }
}