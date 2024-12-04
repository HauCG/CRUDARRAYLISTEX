package com.example.product.service.address;

import com.example.product.DAO.address.AddressDao;
import com.example.product.DAO.address.AddressDaoImpl;
import com.example.product.model.Address;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AddressServiceImpl implements AddressService{

    private final AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<Address> findAllAddresses() throws SQLException {
        return addressDao.findAllAddresses();
    }

    @Override
    public int countAddressesByAccountId(int accountId) throws SQLException {
        return addressDao.countByAccountId(accountId);
    }
}
