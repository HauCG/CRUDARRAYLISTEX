package com.example.product.DAO.account;

import com.example.product.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> findAllAccounts() throws SQLException;
}
