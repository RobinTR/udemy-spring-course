package com.robn.aopdemo.dao;

import com.robn.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
