package repositories;

import models.Customer;
import models.Marketplace;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    public void addToMarketplace(Customer customer, Marketplace marketplace) {
        marketplace.addCustomer(customer);
    }

    public void add (Customer customer) {
        this.customers.add(customer);
    }

    public Customer findByUsername(String username) {
        return customers.stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getAll() {
        return this.customers;
    }

    public List<String> toCSV() {
        List<String> output = new ArrayList<>();
        for (Customer customer : customers) {
            output.add(customer.toCSV());
        }
        return output;
    }
}
