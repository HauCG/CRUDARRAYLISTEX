package com.example.product.service.address;

import com.example.product.DAO.address.AddressDao;
import com.example.product.model.Address;
import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    List<Address> findAllAddresses() throws SQLException;
    int countAddressesByAccountId(int accountId) throws SQLException;
}
