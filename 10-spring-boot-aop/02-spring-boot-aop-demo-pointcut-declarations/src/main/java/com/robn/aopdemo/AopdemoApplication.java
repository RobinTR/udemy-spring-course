package com.robn.aopdemo;

import com.robn.aopdemo.dao.AccountDAO;
import com.robn.aopdemo.dao.MembershipDAO;
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
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO,membershipDAO);
		};
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
