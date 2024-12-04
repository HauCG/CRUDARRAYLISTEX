package com.example.product.model;

public class Account {
    int accountId;
    String accountUserName;
    String accountPassword;
    int accountAddressCount;

    public Account(int accountId, String accountUserName, String accountPassword, int accountAddressCount) {
        this.accountId = accountId;
        this.accountUserName = accountUserName;
        this.accountPassword = accountPassword;
        this.accountAddressCount = accountAddressCount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public int getAccountAddressCount() {
        return accountAddressCount;
    }

    public void setAccountAddressCount(int accountAddressCount) {
        this.accountAddressCount = accountAddressCount;
    }
}
//AccountId INT PRIMARY KEY,
//AccountUserName VARCHAR(30) NOT NULL,
//AccountPassword VARCHAR(30) NOT NULL