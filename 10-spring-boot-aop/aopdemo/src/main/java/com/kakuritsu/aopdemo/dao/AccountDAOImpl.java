package com.kakuritsu.aopdemo.dao;
import com.kakuritsu.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private final String name = "Thodoros";
    @Override
    public void addAccount(Account account, Boolean vipFlag){
       System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ":doWork()");
        return false;
    }

   public String getName(){
       return name;
    }

    @Override
    public List<Account> findAccounts() {
     return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire)  {
        if(tripWire) {
         throw new RuntimeException("No soup for you!!!");
        }
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("thodoros", "Manager"));
        accounts.add(new Account("Anestis", "Employee"));
        return accounts;

    }

}
