package dao;

import models.OrderStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDAO extends Dao {

    public OrderStatusDAO(DaoCredentials daoCredentials) {
        super(daoCredentials.DB_URL, daoCredentials.USER, daoCredentials.PASS);
    }

    public boolean insert(OrderStatus orderStatus) throws SQLException {
        String sql = "INSERT INTO order_statuses (name) VALUES (?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, orderStatus.getName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<OrderStatus> getAll() throws SQLException {
        List<OrderStatus> listOrderStatus = new ArrayList<>();

        String sql = "SELECT * FROM order_statuses";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String name = resultSet.getString("name");

            OrderStatus orderStatus = new OrderStatus(name);
            listOrderStatus.add(orderStatus);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listOrderStatus;
    }

    public boolean delete(int status_id) throws SQLException {
        String sql = "DELETE FROM order_statuses where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, status_id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean deleteAll() throws SQLException {
        String sql = "DELETE FROM order_statuses where id > 0";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        boolean rowDeleted = statement.executeUpdate() > 0;

        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean update(int status_id, OrderStatus orderStatus) throws SQLException {
        String sql = "UPDATE order_statuses SET name = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, orderStatus.getName());
        statement.setInt(2, status_id);

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
}
