package com.example.product.service.account;

import com.example.product.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    List<Account> findAllAccount() throws SQLException;

//    int getNextAccountId() throws SQLException;
//
//    void addAccount(Account account) throws SQLException;
//
//
//
//
//    Account getAccountById(int accountId) throws SQLException;
//
//    void updateAccount(Account account) throws SQLException;
//
//    void deleteAccount(int accountId) throws SQLException;
//
//    List<Account> searchProducts(String keyword) throws SQLException;
}
