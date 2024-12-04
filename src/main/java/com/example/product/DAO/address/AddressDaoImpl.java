package com.example.product.DAO.address;

import com.example.product.connection.DatabaseConnection;
import com.example.product.model.Account;
import com.example.product.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Address> findAllAddresses() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Address");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Address address = new Address(
                    rs.getInt("addressId"),
                    rs.getString("addressNickName"),
                    rs.getString("addressReceiverName"),
                    rs.getString("addressReceiverPhoneNumber"),
                    rs.getString("addressLocation"),
                    rs.getInt("accountId")
            );
            addresses.add(address);
        }
        return addresses;
    }

    @Override
    public int countByAccountId(int accountId) throws SQLException {
        int addressesCount = 0;
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM Address WHERE AccountId = ?");
        statement.setInt(1, accountId);
        ResultSet rs = statement.executeQuery();

        if(rs.next()) {
            addressesCount = rs.getInt(1);
        }
        return addressesCount;
    }
}
