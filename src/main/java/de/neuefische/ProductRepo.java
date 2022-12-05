package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class ProductRepo {
    // Liste von Produkten deklariert "Product" bezieht sich auf Klasse "Product"
    public List<Product> products;  // in Feldern können alle Datentypen (primitive und Klassen) deklariert werden

    // STATIC heißt, dass diese Klassen/Felder/Methoden nur einmalig im kompletten Programm definiert sind.
    // Das bedeutet: es wird KEIN Objekt benötigt, um darauf zuzugreifen.
    // Wird bei Konstanten (nicht füe eine Änderung vorgesehene Klassen/Methoden/Felder) und
    // einfachen, immer gleichen Methoden ( > "Utility Methoden" (nicht gleichbedeutend mit java.util.*)) angewendet.

    // Methodensignatur besteht aus:
    // Access Modifier - Rückgabetyp - selbstgewählter Methodenname - (Parameter = Argumente = REINGABEwerte) {
    //Logik der Methode/Anweisungen
    // }

    // Methode zur Rückgabe einer Liste aller Produkte
    public List<Product> listOfProducts() {
        return products; // Feld products ist innerhalb der Klasse deklariert und daher hier nutzbar
        // Rückgabewert steht nach return

    }

    // Methode zum Zurückgeben eines bestimmten Produkts
    // Rückgabetyp "Product" ist eine Klasse. Heißt: der Rückgabewert (hinter return) muss auch ein "Product" sein
    public Product findProductById(String id) { // laut Freitagsaufgabe Bestellsystem sollte die Methode "getProduct" heißen
        // Name des Arguments steht nicht in Zusammenhang zu irgendwas anderweitig Definiertem
        for (int i = 0; i < products.size(); i++) {
            Product productFromListProducts = products.get(i);  // geht die einzelnen Produkte durch und bekommt ein
            // Produkt (id und name> zurück
            String productId = productFromListProducts.getId();
            if (productId.equals(id)){
                return productFromListProducts;
            }
        }
        throw new IllegalArgumentException("Diese Produkt-ID ist nicht vorhanden.");
    }

    }

