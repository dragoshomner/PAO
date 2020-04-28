package repositories;

import models.Marketplace;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
    }

    public void addToMarketplace(Product product, Marketplace marketplace) {
        marketplace.addProduct(product);
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product findByCode(String code) {
        return products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
