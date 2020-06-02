package dao;

import models.Marketplace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarketplaceDAO extends Dao {
    
    public MarketplaceDAO(DaoCredentials daoCredentials) {
        super(daoCredentials.DB_URL, daoCredentials.USER, daoCredentials.PASS);
    }

    public boolean insert(Marketplace marketplace) throws SQLException {
        String sql = "INSERT INTO marketplaces (code, name) VALUES (?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, marketplace.getCode());
        statement.setString(2, marketplace.getName());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Marketplace> getAll() throws SQLException {
        List<Marketplace> listMarketplace = new ArrayList<>();

        String sql = "SELECT * FROM marketplaces";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String code = resultSet.getString("code");
            String name = resultSet.getString("name");

            Marketplace marketplace = new Marketplace(code, name);
            listMarketplace.add(marketplace);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listMarketplace;
    }

    public boolean delete(int marketplace_id) throws SQLException {
        String sql = "DELETE FROM marketplaces where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, marketplace_id);

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean deleteAll() throws SQLException {
        String sql = "DELETE FROM marketplaces where id > 0";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        boolean rowDeleted = statement.executeUpdate() > 0;

        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean update(int marketplace_id, Marketplace marketplace) throws SQLException {
        String sql = "UPDATE Marketplaces SET code = ?, name = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, marketplace.getCode());
        statement.setString(2, marketplace.getName());
        statement.setInt(3, marketplace_id);

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }
}
