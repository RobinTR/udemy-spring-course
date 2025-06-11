package com.robn.aopdemo;

import com.robn.aopdemo.dao.AccountDAO;
import com.robn.aopdemo.dao.MembershipDAO;
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
    CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            //demoTheBeforeAdvice(accountDAO,membershipDAO);
            //demoTheAfterReturningAdvice(accountDAO);
            demoTheAfterThrowingAdvice(accountDAO);
        };
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
