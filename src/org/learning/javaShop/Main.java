package org.learning.javaShop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many products are you adding?");
        int productCount = Integer.parseInt(scan.nextLine());
        Product[] products = new Product[productCount];
        for (int i = 0; i < products.length; i++) {
            System.out.println("Product " + (i + 1) + " of " + productCount);
            products[i] = Product.insertProduct();
            System.out.println("id: " + products[i].getCode());
            System.out.println(" ");
        }

        System.out.println(" ***** Products Added ***** ");
        for (Product product : products) {
            System.out.println(" ");
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getFormattedPrice());
            System.out.println("Price including VAT (20%): " + product.getFormattedTaxedPrice());
            System.out.println("Product Code: " + product.getCode());
        }
    }
}
