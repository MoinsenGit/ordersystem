package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // main Methode muss in jedem Projekt vorhanden sein - ist Startpunkt - braucht aber keine eigene Klasse
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        ProductRepo productRepo = new ProductRepo(list);

        System.out.println(productRepo.products);

    }
}