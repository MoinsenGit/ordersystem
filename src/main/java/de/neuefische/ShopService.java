package de.neuefische;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor


public class ShopService {
   private ProductRepo productRepo;
   private  OrderRepo orderRepo;


    public Product getProduct(String id) {
        Product productFromListProducts = productRepo.findProductById(id);
        return productFromListProducts;
    }

    public List<Product> listProducts() {
        List<Product> listOfProducts = productRepo.listOfProducts();
        return listOfProducts;
    }

    public Order getOrder(String id) {
        Order orderFromListOrders = orderRepo.getOrder(id);
        return orderFromListOrders;
    }

    public List<Order> listOrders() {
        List<Order> listOfOrders = orderRepo.list();
        return listOfOrders;
    }

    // Zusätzlich kann er eine neue Bestellung aufgeben. Für jede neue
    // Bestellung möchte er die entsprechenden Produkt-Ids mitangeben.

    public String addNewOrder(List<String> productIdsForOrder) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productIdsForOrder.size(); i++) {
            String productIdForOrder = productIdsForOrder.get(i);
            Product productForOrder = productRepo.findProductById(productIdForOrder);
            products.add(productForOrder);
        }

        int orderId = (int) Math.random();
        Order newOrder = new Order("Order Id " + orderId, products); // neue Bestellung erstellt
        orderRepo.addOrder(newOrder); // neue Bestellung der Bestellliste hinzugefügt
        return newOrder.getId();
    }

}




