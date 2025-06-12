package com.robn.aopdemo;

import com.robn.aopdemo.dao.AccountDAO;
import com.robn.aopdemo.dao.MembershipDAO;
import com.robn.aopdemo.service.TrafficFortuneService;
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
    CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            //demoTheBeforeAdvice(accountDAO,membershipDAO);
            //demoTheAfterReturningAdvice(accountDAO);
            //demoTheAfterThrowingAdvice(accountDAO);
            //demoTheAfterAdvice(accountDAO);
            //demoTheAroundAdvice(trafficFortuneService);
            demoTheAroundAdviceHandleException(trafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
        System.out.println("Calling getFortune");
        boolean tripWire = true;

        String data = trafficFortuneService.getFortune(tripWire);

        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling getFortune");

        String data = trafficFortuneService.getFortune();

        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program: caught exception: " + e);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("-----------------------------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
			boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain Program: caught exception: " + e);
        }

        System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
        System.out.println("-----------------------------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-----------------------------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("Test");
        account.setLevel("Platinum");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        accountDAO.getName();
        accountDAO.setName("RobN");
        accountDAO.getServiceCode();
        accountDAO.setServiceCode("ServiceCode123");
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

}
