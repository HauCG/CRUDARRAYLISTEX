package com.example.product.service.account;

import com.example.product.DAO.account.AccountDao;
import com.example.product.DAO.account.AccountDaoImpl;
import com.example.product.model.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService{
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public List<Account> findAllAccount() throws SQLException {
        return accountDao.findAllAccounts();
    }
}
