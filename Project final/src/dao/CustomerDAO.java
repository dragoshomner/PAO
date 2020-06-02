package dao;

import models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends Dao {

    public CustomerDAO(DaoCredentials daoCredentials) {
        super(daoCredentials.DB_URL, daoCredentials.USER, daoCredentials.PASS);
    }

    public boolean insert(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (name, username) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getUsername());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();

        String sql = "SELECT * FROM customers";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String username = resultSet.getString("username");

            Customer Customer = new Customer(username, name);
            listCustomer.add(Customer);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listCustomer;
    }

    public boolean delete(int customer_id) throws SQLException {
        String sql = "DELETE FROM customers where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, customer_id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean deleteAll() throws SQLException {
        String sql = "DELETE FROM customers where id > 0";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        boolean rowDeleted = statement.executeUpdate() > 0;

        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean update(int customer_id, Customer customer) throws SQLException {
        String sql = "UPDATE customers SET name = ?, username = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getUsername());
        statement.setInt(3, customer_id);

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
}
