package org.learning.javaShop;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Product {
    private String code;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final BigDecimal taxedPrice;
    private final BigDecimal VAT;
    private final String formattedPrice;
    private final String formattedTaxedPrice;


    public Product(String name, String description, BigDecimal price) {
        this.code = generateCode();
        this.name = name;
        this.description = description;
        this.price = price;
        VAT = BigDecimal.valueOf(1.20);
        this.taxedPrice = price.multiply(VAT);
        this.formattedPrice = NumberFormat.getCurrencyInstance().format(price);
        this.formattedTaxedPrice = NumberFormat.getCurrencyInstance().format(taxedPrice);
    }

    public String generateCode() {
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int randInt = r.nextInt(10000000);
            code = String.format("%08d", randInt);
        }

        return code;
    }

    public static Product insertProduct() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Insert Product Name");
        String name = scan.nextLine();

        System.out.println("Insert Product Description");
        String description = scan.nextLine();

        System.out.println("Insert Product Price");
        double price = Double.parseDouble(scan.nextLine());

        return new Product(name, description, BigDecimal.valueOf(price));
    }

//    GETTERS AND SETTERS

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxedPrice() {
        return taxedPrice;
    }

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public String getFormattedTaxedPrice() {
        return formattedTaxedPrice;
    }

    public BigDecimal getVAT() {
        return VAT;
    }
}
