package com.kakuritsu.aopdemo;

import com.kakuritsu.aopdemo.dao.AccountDAO;
import com.kakuritsu.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
    return runner->{
        System.out.println("Hello AOP!");
          demoTheBeforeAdvice(accountDAO,membershipDAO);


		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO){
		accountDAO.addAccount(new Account("thodoros","enabled"),true);
		membershipDAO.addSillyMember();
	}

}
