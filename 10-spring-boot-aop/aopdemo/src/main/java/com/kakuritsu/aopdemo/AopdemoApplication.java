package com.kakuritsu.aopdemo;

import com.kakuritsu.aopdemo.dao.AccountDAO;
import com.kakuritsu.aopdemo.dao.MembershipDAO;
import com.kakuritsu.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO,TrafficFortuneService trafficFortuneService) {
		return runner -> {
			System.out.println("Hello AOP!");
			demoTheBeforeAdvice(accountDAO, membershipDAO, trafficFortuneService);


		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService)  {
//		accountDAO.addAccount(new Account("thodoros","enabled"),true);
//		accountDAO.doWork();
//		membershipDAO.addSillyMember();
//		membershipDAO.goToSleep();
//		System.out.println(accountDAO.getName());
//		System.out.println(accountDAO.findAccounts());
//		List<Account> theAccounts = null;

//		try {
//			boolean tripWire = true;
//			theAccounts = accountDAO.findAccounts(tripWire);
//		}
//		catch(Exception exc){
//        System.out.println("\n\nMain Program: caught exception: " + exc);
//		}
//		try {
//			boolean tripWire = true;
//			theAccounts = accountDAO.findAccounts(true);
//		}
//		catch(Exception exc){
//			System.out.println("\n\nMain Program: caught exception: " + exc);
//		}
//	}
  	   try {
          System.out.println(trafficFortuneService.getFortune(true));
	   }
		 catch(RuntimeException exc) {
			 System.out.println(exc);

		 }
    }

}