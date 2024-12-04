package com.example.product.model;

public class Address {
    int addressId;
    String addressNickName;
    String addressReceiverName;
    String addressReceiverPhoneNumber;
    String addressLocation;
    int accountId;

    public Address(int addressId, String addressNickName, String addressReceiverName, String addressReceiverPhoneNumber, String addressLocation, int accountId) {
        this.addressId = addressId;
        this.addressNickName = addressNickName;
        this.addressReceiverName = addressReceiverName;
        this.addressReceiverPhoneNumber = addressReceiverPhoneNumber;
        this.addressLocation = addressLocation;
        this.accountId = accountId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressNickName() {
        return addressNickName;
    }

    public void setAddressNickName(String addressNickName) {
        this.addressNickName = addressNickName;
    }

    public String getAddressReceiverName() {
        return addressReceiverName;
    }

    public void setAddressReceiverName(String addressReceiverName) {
        this.addressReceiverName = addressReceiverName;
    }

    public String getAddressReceiverPhoneNumber() {
        return addressReceiverPhoneNumber;
    }

    public void setAddressReceiverPhoneNumber(String addressReceiverPhoneNumber) {
        this.addressReceiverPhoneNumber = addressReceiverPhoneNumber;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
