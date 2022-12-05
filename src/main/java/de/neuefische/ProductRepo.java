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
    // Konstruktor - der ist durch @AllArgsConstructor schon vorhanden und muss daher nicht generiert/geschrieben werden.
    // Felder der Klasse werden durch den Aufruf des Konstruktors initialisiert.
    // Aufruf erfolgt durch Name der Klasse - Vairablenname = new Name der Klasse(Variable die vorher deklariert werden musste);
    // ProductRepo productRepo = new ProductRepo(list);
    // ProductRepo productRepo = new ProductRepo(new ArrayList<>());

    /*
    public ProductRepo(List<Product> products) {
        this.products = products;
    }
    */

    // Methode zum Zurückgeben eines bestimmten Produkts
    // Rückgabetyp "Product" ist eine Klasse. Heißt: der Rückgabewert (hinter return) muss auch ein "Product" sein
    public Product findProductById(String id) { // laut Freitagsaufgabe Bestellsystem sollte die Methode "getProduct" heißen
        // Name des Arguments steht nicht in Zusammenhang zu irgendwas anderweitig Definiertem
        // Argumenttyp ist abhängig von dem, was ich mit dem Wert machen möchte. Hier brauche ich einen String,
        // da die ID des Product auch ein String ist
        for (int i = 0; i < products.size(); i++) {
        // for (Initialisierung der Startvariablen i; Abbruchbedingung der Schleife (solange die Bedingung gilt,
            // wird Schleife durchlaufen. Sobald die Bedingung nicht mehr gilt, wird abgebrochen und die nächstfolgende
            // Zeile nach der for-Schleife ausgeführt); Aktion, die nach jedem Schleifendurchlauf ausgeführt wird)

            Product productFromListProducts = products.get(i);  // geht die einzelnen Produkte durch und bekommt ein
            // Produkt (id und name) zurück
            // Immer von RECHTS des Gleichheitszeichens nach links lesen!
            // products ist ein deklarierter Feldname oder eine im Methodenkopf deklarierter Parameter - hier der Feldname
            // .get(i) ist eine Methode aus dem List Interface, wäre Products ein String, stünden die dazugehörigen
                // Methoden zur Verfügung
            // products.get(i) bedeutet: hole das Produkt an der Stelle i des Index aus der Liste
            // das Gleichheitszeichen bedeutet: übertrage den Wert rechts vom = auf die Variable links (=Zuweisung/assign)
            // es wird das Product wie in der Klasse definiert mit ID und Name zurück gegeben

            String productId = productFromListProducts.getId(); //
            // Immer von RECHTS des Gleichheitszeichens nach links lesen!
            // @Data von lombok hat die Methode getId erzeugt - ist ein "normaler" Getter - kann nicht auf eine Liste/String
            // oder jede andere Klasse/primitiven Datentyp angewendet werden, die den Getter nicht enthält - hier nutzbar,
            // weil die Klasse Product die Getter enthält
            // Methode gibt die id zurück und assignt sie der Variablen String mit dem Namen productId

            if (productId.equals(id)){ // == geht nicht mit Strings
                return productFromListProducts;
            }
        }
        throw new IllegalArgumentException("Diese Produkt-ID ist nicht vorhanden.");

    }

    }

