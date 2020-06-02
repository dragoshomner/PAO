import gui.FirstFrame;
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

		Customer dragos = customerService.findByUsername("dragos");
		dragos.addToCart(productService.findByCode("ROSII"), 5);
		dragos.addToCart(productService.findByCode("CASTRAVETI"), 3);
		dragos.toOrder();
		dragos.showOrders();

		Marketplace emag = marketplaceService.findByCode("EMAG");
		emag.showOrders();

		// se poate face si pentru marketplace, product, etc
		writer.write("output_customer.csv", customerService.toCSV());

		new FirstFrame(marketplaceService);

		marketplaceService.displayAll();
		marketplaceService.displayAllSortedByName();
		marketplaceService.displayAllSortedByNumberOfCustomers();
		marketplaceService.displayCustomers();
		marketplaceService.displayCustomersPerMarketplace();
	}

}
