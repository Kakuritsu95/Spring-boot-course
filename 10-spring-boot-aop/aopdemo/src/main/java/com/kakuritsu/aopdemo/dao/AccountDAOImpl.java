package com.kakuritsu.aopdemo.dao;
import com.kakuritsu.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, Boolean vipFlag){
       System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

}
