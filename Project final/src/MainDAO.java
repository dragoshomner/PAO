import dao.*;
import models.Customer;
import models.Marketplace;
import models.OrderStatus;
import models.Product;

import java.sql.SQLException;
import java.util.List;

public class MainDAO {

    public static void main(String[] args) throws SQLException {
        DaoCredentials daoCredentials = DaoCredentials.getInstance();

        CustomerDAO customerDAO = new CustomerDAO(daoCredentials);
        MarketplaceDAO marketplaceDAO = new MarketplaceDAO(daoCredentials);
        ProductDAO productDAO = new ProductDAO(daoCredentials);
        OrderStatusDAO orderStatusDAO = new OrderStatusDAO(daoCredentials);

        customerDAO.insert(new Customer("dragos123", "dragos"));
        customerDAO.insert(new Customer("alex_vasile", "alex"));
        List<Customer> customers = customerDAO.getAll();
        System.out.println(customers);
        customerDAO.update(1, new Customer("dragos1234", "dragos"));
        // customerDAO.delete(1);
        // ATENTIE!! Sterg toate datele la final de executie :)
        customerDAO.deleteAll();

        marketplaceDAO.insert(new Marketplace("EMAG", " EmagRomania"));
        marketplaceDAO.insert(new Marketplace("ALTEX", " Altex Romania"));
        List<Marketplace> marketplaces = marketplaceDAO.getAll();
        System.out.println(marketplaces);
        marketplaceDAO.update(1, new Marketplace("EMAG", "Emag Romania"));
        marketplaceDAO.deleteAll();

        productDAO.insert(new Product("MAR", "mere", 3.50));
        List<Product> products = productDAO.getAll();
        System.out.println(products);
        productDAO.update(1, new Product("MERE", "mere", 3.50));
        productDAO.deleteAll();

        orderStatusDAO.insert(new OrderStatus("preluata"));
        orderStatusDAO.insert(new OrderStatus("acceptata"));
        List<OrderStatus> orderStatuses = orderStatusDAO.getAll();
        System.out.println(orderStatuses);
        orderStatusDAO.update(1, new OrderStatus("ridicata"));

    }
}
