package de.neuefische;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ShopServiceTest {
 ShopService shopService = null;

 @BeforeEach
void initShopService() {
    List<Product> products = List.of(
            new Product("Product 1", "Product Name for Id 1"),
            new Product("Product 3", "Product Name for Id 3"),
            new Product("Product 7", "Product Name for Id 7"),
            new Product("Product 4", "Product Name for Id 4")
    );
    ProductRepo productRepo = new ProductRepo(products);
    OrderRepo orderRepo = new OrderRepo(new ArrayList<>());
    this.shopService = new ShopService(productRepo, orderRepo);
}
    @Test
    void showOneProductOnConsole() {
         // WHEN - wenn es ein Produkt in gibt, gib es auf der Konsole aus
        Product result = shopService.getProduct("Product 3");

        // THEN
        assertNotNull(result);
        assertEquals(result.getName(), "Product Name for Id 3");

    }
    @Test
    void showAllProductsOnConsole() {
        // WHEN - wenn es ein Produkt in gibt, gib es auf der Konsole aus
        List<Product> result = shopService.listProducts();

        // THEN
        assertNotNull(result);
        assertEquals(result.size(), 4);
        assertEquals(result.get(0).getId(), "Product 1");
        assertEquals(result.get(1).getId(), "Product 3");
        assertEquals(result.get(2).getId(), "Product 7");
        assertEquals(result.get(3).getId(), "Product 4");
    }

        @Test
    void everyOrderContainsTheProductIds() {
            // GIVEN
            List<String> productIds = List.of("Product 1", "Product 7", "Product 4");

            // WHEN
             String orderId = shopService.addNewOrder(productIds);
            Order result = shopService.getOrder(orderId);

            // THEN
            assertNotNull(result);
            assertEquals(result.getProducts().size(), 3);
            assertEquals(result.getProducts().get(0).getId(), "Product 1");
            assertEquals(result.getProducts().get(1).getId(), "Product 7");
            assertEquals(result.getProducts().get(2).getId(), "Product 4");
        }

        @Test
    void showSpecificOrderBasedOnIdOfOrder() {
            // GIVEN
            String orderId1 = shopService.addNewOrder(Arrays.asList());
            String orderId2 =  shopService.addNewOrder(Arrays.asList());
            String orderId3 = shopService.addNewOrder(Arrays.asList());
            String orderId4 = shopService.addNewOrder(Arrays.asList());

            // WHEN
            List<Order> result = shopService.listOrders();

            // THEN
            assertNotNull(result);
            assertEquals(result.size(), 4);
            assertEquals(result.get(0).getId(), orderId1);
            assertEquals(result.get(1).getId(), orderId2);
            assertEquals(result.get(2).getId(), orderId3);
            assertEquals(result.get(3).getId(), orderId4);
     }
            @Test
    void showListOfAllOrders() {
        // GIVEN
                String orderId1 = shopService.addNewOrder(Arrays.asList());
                String orderId2 =  shopService.addNewOrder(Arrays.asList());
                String orderId3 = shopService.addNewOrder(Arrays.asList());
                String orderId4 = shopService.addNewOrder(Arrays.asList());

        // WHEN
               List<Order> result = shopService.listOrders();

        // THEN
                assertEquals(result.size(), 4);
                assertEquals(result.get(0).getId(), orderId1);
                assertEquals(result.get(1).getId(), orderId2);
                assertEquals(result.get(2).getId(), orderId3);
                assertEquals(result.get(3).getId(), orderId4);
    }
    @Test
    void addNewOrderToOrderList() {
        // GIVEN
        List<String> productIds = List.of("Product 1", "Product 7", "Product 4");

        // WHEN
final String orderId1 =        shopService.addNewOrder(productIds);

        // THEN
        assertEquals(shopService.listOrders().size(), 1);
        assertNotNull(shopService.getOrder(orderId1));

        // WHEN
        final String orderId2 = shopService.addNewOrder(productIds);

        // THEN
        assertEquals(shopService.listOrders().size(), 2);
        assertNotNull(shopService.getOrder(orderId2));
    }

    @Test
    void addNewOrderWithMissingProduct() {
    try {
        // GIVEN
        List<String> productIds = List.of("Product 112");

        // WHEN
               shopService.addNewOrder(productIds);
    }catch (IllegalArgumentException e) {
        // THEN
        assertEquals(e.getMessage(), "Diese Produkt-ID ist nicht vorhanden.");
    }
    }
}

