package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class ProductRepo {

    public List<Product> products;


    // Methode zum Auflisten aller Produkte
    public List<Product> listOfProducts() {

        return products;
    }

    // Methode zum Zurückgeben eines bestimmten Produkts
    public Product getProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            Product productFromListProducts = products.get(i);  // geht die einzelnen Prosukte durch und bekommt ein Produkt (id und name> zurück
            String productId = productFromListProducts.getId();
            if (productId.equals(id)){
                return productFromListProducts;
            }
        }
        throw new IllegalArgumentException("Diese Produkt-ID ist nicht vorhanden.");
    }


}
