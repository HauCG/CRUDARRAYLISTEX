package com.example.product.DAO.account;

import com.example.product.connection.DatabaseConnection;
import com.example.product.model.Account;
import com.example.product.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Account> findAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT a.AccountId, a.AccountUserName, a.AccountPassword, COUNT(ad.AddressId) AS accountAddressCount " +
                "FROM Account a " +
                "LEFT JOIN Address ad ON a.AccountId = ad.AccountId " +
                "GROUP BY a.AccountId");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Account account = new Account(
                    rs.getInt("accountId"),
                    rs.getString("accountUserName"),
                    rs.getString("accountPassword"),
                    rs.getInt("accountAddressCount")
            );
            accounts.add(account);
        }
        return accounts;
    }

}
