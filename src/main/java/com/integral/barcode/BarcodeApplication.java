package com.integral.barcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarcodeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BarcodeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
