package com.example.product.DAO.address;

import com.example.product.model.Account;
import com.example.product.model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    List<Address> findAllAddresses() throws SQLException;
    int countByAccountId(int accountId) throws SQLException;
}
