package pl.jkanclerz.productcatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    @Test
    void itAllowsToListMyProducts() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        List<Product> products = catalog.allProducts();
        //Assert
        assertListIsEmpty(products);
    }

    @Test
    void itAllowsToAddProduct() {
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("lego set 8083", "nice one");

        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    @Test
    void itAllowsToLoadProductDetails() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct("lego set 8083", "nice one");

        Product loadedProduct = catalog.loadById(productId);
        assert loadedProduct.getId().equals(productId);
    }

    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego set 8083", "nice one");

        catalog.changePrice(productId, BigDecimal.valueOf(20.20));

        Product loadedProduct = catalog.loadById(productId);
        assertEquals(BigDecimal.valueOf(20.20), loadedProduct.getPrice());
    }

    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego set 8083", "nice one");

        catalog.assignImage();
    }

    @Test
    void itAllowsToPublishProduct() {

    }

    @Test
    void publicationIsPossibleWhenPriceAndImageAreDefined() {

    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

    private void assertListIsEmpty(List<Product> products) {
        assert 0 == products.size();
    }
}
