package de.neuefische;



import lombok.Data;

import java.util.List;

@Data

public class Order {
    String id;
    List<Product> products;

    public Order(String idPh, List<Product> productsPh) {
        this.id = idPh;
        this.products = productsPh;
    }
}
