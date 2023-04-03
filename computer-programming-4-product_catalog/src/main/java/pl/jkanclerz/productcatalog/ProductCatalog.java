package pl.jkanclerz.productcatalog;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
    }

    public List<Product> allProducts() {
        return products.values().stream().collect(Collectors.toList());
    }

    public String addProduct(String name, String desc) {
        Product newOne =  new Product(
                UUID.randomUUID(),
                name,
                desc
        );

        products.put(newOne.getId(), newOne);

        return newOne.getId();
    }

    public Product loadById(String productId) {
        return products.get(productId);
    }
    public void changePrice(String productId, BigDecimal newPrice) {
        Product product = loadById(productID);

        product.changePrice(newPrice);
    }
}