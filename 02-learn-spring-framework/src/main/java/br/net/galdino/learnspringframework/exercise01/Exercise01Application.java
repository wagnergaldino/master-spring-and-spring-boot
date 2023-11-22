package br.net.galdino.learnspringframework.exercise01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Exercise01Application {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(Exercise01Application.class)) {
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}

	}

}
