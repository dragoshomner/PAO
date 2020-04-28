import models.Customer;
import models.Marketplace;
import models.OrderStatus;
import models.Product;
import repositories.CustomerRepository;
import repositories.MarketplaceRepository;
import repositories.ProductRepository;
import services.CustomerService;
import services.MarketplaceService;
import services.ProductService;
import utils.CSVReader;
import utils.CSVWriter;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Repositories
		MarketplaceRepository marketplaceRepository = new MarketplaceRepository();
		ProductRepository productRepository = new ProductRepository();
		CustomerRepository customerRepository = new CustomerRepository();

		// Services
		MarketplaceService marketplaceService = new MarketplaceService(marketplaceRepository);
		ProductService productService = new ProductService(productRepository, marketplaceRepository);
		CustomerService customerService = new CustomerService(customerRepository, marketplaceRepository);

		CSVReader reader = CSVReader.getInstance();
		CSVWriter writer = CSVWriter.getInstance();

		marketplaceService.addBulkString(reader.read("src/csv/marketplaces.csv"));
		productService.addBulkString(reader.read("src/csv/products.csv"));
		customerService.addBulkString(reader.read("src/csv/customers.csv"));
		OrderStatus.initialize(reader.read("src/csv/status.csv"));
		marketplaceService.displayAll();

		Customer dragos = customerService.findByUsername("dragos");
		dragos.addToCart(productService.findByCode("ROSII"), 5);
		dragos.addToCart(productService.findByCode("CASTRAVETI"), 3);
		dragos.toOrder();
		dragos.showOrders();

		Marketplace emag = marketplaceService.findByCode("EMAG");
		emag.showOrders();

		// se poate face si pentru marketplace, product, etc
		writer.write("output_customer.csv", customerService.toCSV());

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
