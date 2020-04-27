package repositories;

import models.Marketplace;
import models.Product;

public class ProductRepository {

    public ProductRepository() { }

    public void addToMarketplace(Product product, Marketplace marketplace) {
        marketplace.addProduct(product);
    }
}
