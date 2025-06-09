package com.robn.aopdemo.dao;

import com.robn.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork() method called");

        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName() method called");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName() method called");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode() method called");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode() method called");
        this.serviceCode = serviceCode;
    }
}
