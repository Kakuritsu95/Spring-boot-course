package com.kakuritsu.aopdemo.dao;


import com.kakuritsu.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
     void addAccount(Account account, Boolean vipFlag);

     boolean doWork();

     String getName();

     List<Account> findAccounts();
     List<Account> findAccounts(boolean tripWire);
}
