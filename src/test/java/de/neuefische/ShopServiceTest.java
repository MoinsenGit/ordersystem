package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ShopServiceTest {

    @Test
    void showOneProductOnConsole() {
        // GIVEN - es gibt ein Produkt1
        Product product1 = new Product("Produkt1", "ID-Produkt1");

        // WHEN - wenn es ein Produkt in gibt, gib es auf der Konsole aus
      //  List<Product> actual = this.product1; ???

        // THEN

    }
    @Test
    void showAllProductsOnConsole() {
        // GIVEN - es gibt mehrere Produkte
        // WHEN - wenn es mehrere Produkte
        // THEN -
    }
        @Test
    void executeAnOrder() {
        // GIVEN
        // WHEN
        // THEN
    }
        @Test
    void everyOrderContainsTheProductIds() {
        // GIVEN
        // WHEN
        // THEN
    }
        @Test
    void showSpecificOrderBasedOnIdOfOrder() {
        // GIVEN
        // WHEN
        // THEN
    }
            @Test
    void showListOfAllOrders() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void addNewOrder() {
        // GIVEN
        List<Product> products = List.of(
                new Product("Product 1", "Product Name for Id 1"),
                new Product("Product 3", "Product Name for Id 3"),
                new Product("Product 7", "Product Name for Id 7"),
                new Product("Product 4", "Product Name for Id 4")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>());
        ShopService shopService = new ShopService(productRepo, orderRepo);

        List<String> productIds = List.of("Product 1", "Product 7", "Product 4");

        // WHEN
        shopService.addNewOrder(productIds);
        // THEN

    }

}