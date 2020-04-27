import models.Customer;
import models.Marketplace;
import models.Product;
import repositories.MarketplaceRepository;
import services.MarketplaceService;
import utils.CSVReader;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		MarketplaceRepository marketplaceRepository = new MarketplaceRepository();
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository);
		CSVReader reader = CSVReader.getInstance();

		List<Marketplace> marketplaces = reader.readMarketplace("src/csv/marketplaces.csv");
		marketplaceService.addBulk(marketplaces);
		marketplaceService.displayAll();

//		Marketplace emag = new Marketplace("emag");
//		Marketplace altex = new Marketplace("altex");
//		Marketplace olx = new Marketplace("olx");
//		marketplaceService.addMatketplace(emag);
//		marketplaceService.addMatketplace(altex);
//		marketplaceService.addMatketplace(olx);
//
//		Customer customer1 = new Customer("Dragos");
//		Customer customer2 = new Customer("Alex");
//		emag.addCustomer(customer1);
//		emag.addCustomer(customer2);
//
//		Product product1 = new Product("Rosii", 3);
//		Product product2 = new Product("Mere", 5);
//		Product product3 = new Product("Pufuleti", 2);
//		emag.addProduct(product1);
//		emag.addProduct(product2);
//		emag.addProduct(product3);
//
//		customer1.addToCart(product1, 4);
//		customer1.addToCart(product2, 5);
//		customer1.addToCart(product1, 6);
//		customer1.toOrder();
//
//		customer1.addToCart(product1, 3);
//		customer1.addToCart(product3, 2);
//		customer1.toOrder();
//
//		customer1.showOrders();
//
//		customer2.addToCart(product1, 1);
//		customer2.addToCart(product2, 2);
//		customer2.toOrder();
//
//		emag.showOrders();
//
//		marketplaceService.displayAll();
//		marketplaceService.displayAllSortedByName();
//		marketplaceService.displayAllSortedByNumberOfCustomers();
//		marketplaceService.displayCustomersPerMarketplace();
	}

}
