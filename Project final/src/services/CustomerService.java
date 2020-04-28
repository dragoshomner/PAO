package services;

import models.Customer;
import models.Marketplace;
import repositories.CustomerRepository;
import repositories.MarketplaceRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MarketplaceRepository marketplaceRepository;

    public CustomerService(CustomerRepository customerRepository,
                           MarketplaceRepository marketplaceRepository) {
        this.customerRepository = customerRepository;
        this.marketplaceRepository = marketplaceRepository;
    }

    public void addBulkString(List<List<String>> input) {
        for (List<String> productString : input) {
            Customer customer = new Customer(productString.get(0), productString.get(1));
            Marketplace marketplace = marketplaceRepository.findByCode(productString.get(2));
            customerRepository.addToMarketplace(customer, marketplace);
            customerRepository.add(customer);
        }
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
}
