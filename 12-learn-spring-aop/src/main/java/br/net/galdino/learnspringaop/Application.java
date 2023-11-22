package br.net.galdino.learnspringaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.net.galdino.learnspringaop.business.BusinessService1;
import br.net.galdino.learnspringaop.business.BusinessService2;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private BusinessService1 businessService1;
	private BusinessService2 businessService2;
	
	public Application(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Max value returned is {}", businessService1.calculateMax());
		logger.info("Min value returned is {}", businessService2.calculateMin());
	}

}
