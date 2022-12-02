package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRepo {

    private List<Order> orders;

    // Methode zum Auflisten aller Orders - da List<Order> orders private Methode nötig, um auf Listen zuzugreifen
    public List<Order> list() {

        return orders;
    }

    // Methode zum Zurückgeben einer Order zu einer bestimmten ID
    public Order getOrder(String id) {
        for (int i = 0; i < orders.size(); i++) {
            Order orderFromListOrders = orders.get(i);  // geht die einzelnen Orders durch und bekommt eine Order (id und List<Product> zurück
            String orderId = orderFromListOrders.getId();
            if (orderId.equals(id)){
                return orderFromListOrders;
            }
        }
        throw new IllegalArgumentException("Diese Order-ID ist nicht vorhanden.");
    }

    // Methode zum Hinzufügen von einer Bestellung zur List<Order> orders
    public void addOrder (Order orderToAdd) {
        orders.add(orderToAdd);
    }
    }

