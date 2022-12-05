package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // main Methode muss in jedem Projekt vorhanden sein - ist Startpunkt - braucht aber keine eigene Klasse
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        Product product1 = new Product("1", "Product-1");
        Product product2 = new Product("2", "Product-2");
        list.add(product1);
        list.add(product2);

        ProductRepo productRepo = new ProductRepo(list);

        Product dings = productRepo.findProductById("2");
        System.out.println(dings);


       // System.out.println(productRepo.products);

    }
}