package dao;

import models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends Dao {
    public ProductDAO(DaoCredentials daoCredentials) {
        super(daoCredentials.DB_URL, daoCredentials.USER, daoCredentials.PASS);
    }

    public boolean insert(Product product) throws SQLException {
        String sql = "INSERT INTO products (code, name, price) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getCode());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Product> getAll() throws SQLException {
        List<Product> listProduct = new ArrayList<>();

        String sql = "SELECT * FROM products";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");

            Product product = new Product(code, name, price);
            listProduct.add(product);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProduct;
    }

    public boolean delete(int product_id) throws SQLException {
        String sql = "DELETE FROM products where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, product_id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean deleteAll() throws SQLException {
        String sql = "DELETE FROM products where id > 0";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        boolean rowDeleted = statement.executeUpdate() > 0;

        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean update(int product_id, Product product) throws SQLException {
        String sql = "UPDATE products SET code = ?, name = ?, price = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getCode());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setInt(4, product_id);

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
}
