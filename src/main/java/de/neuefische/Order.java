package de.neuefische;



import lombok.Data;

import java.util.List;

@Data

// ACCESS MODIFIER bei Klasse/Methode/Feld
// public heißt: kann immer überall genutzt werden - Klassen sind zu ca 80 % public
// protected heißt: kann nur in aktueller Klasse und in "Kindern = subclasses" genutzt werden
// private heißt: kann nur innerhalb der aktuellen Klasse genutzt werden - Felder macht man üblicherweise private
//      > siehe "Encapsulation = Information Hiding" = damit nicht jeder die Werte ändern kann und damit die
//      Methoden ggf. nicht mehr funktionieren
// wenn keine Angabe: "package private" - das heißt, nur innerhalb des aktuellen Packages nutzbar
public class Order {
    String id; // Bestellnummer = Feld der Klasse = deklarierte Variablen
    List<Product> products; // Liste der Produkte, die bestellt werden = Feld der Klasse = deklarierte Variablen

    // Konstruktor - muss in Klasse angelegt werden, damit Objekte der Klasse erstellt werden können
    public Order(String id, List<Product> products) // Argument=Parameter in () - in Methode sind das REINGABEwerte
    {
        this.id = id;  // this verhindert hier Namenskollisionen, da es "id" schon als Argument gibt.
        this.products = products;
    }
    /* wenn KEIN Konstruktor erstellt wird, gibt es einen Default Konstruktor - initialisiert mit Defaultwerten.
    Bsp. int = 0; boolean = false;

    public Order() {
        this.id = null;
        this.products = null;
    }

     */
}
