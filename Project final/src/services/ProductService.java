package services;

import models.Marketplace;
import models.Product;
import repositories.MarketplaceRepository;
import repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;
    private final MarketplaceRepository marketplaceRepository;

    public ProductService(ProductRepository productRepository,
                          MarketplaceRepository marketplaceRepository) {
        this.productRepository = productRepository;
        this.marketplaceRepository = marketplaceRepository;
    }

    public void addBulkString(List<List<String>> input) {
        for (List<String> productString : input) {
            Product product = new Product(productString.get(0),
                    productString.get(1),
                    Double.parseDouble(productString.get(2)));
            Marketplace marketplace = marketplaceRepository.findByCode(productString.get(3));
            productRepository.addToMarketplace(product, marketplace);
            productRepository.add(product);
        }
    }

    public Product findByCode(String code) {
        return productRepository.findByCode(code);
    }

    public List<String> toCSV() {
        return productRepository.toCSV();
    }

}
