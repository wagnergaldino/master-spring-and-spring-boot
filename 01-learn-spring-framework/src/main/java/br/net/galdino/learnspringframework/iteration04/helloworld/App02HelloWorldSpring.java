package br.net.galdino.learnspringframework.iteration04.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		//Launch a Spring Context
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			
			//Configure what we want Spring to manage
			//HelloWorldConfiguration - @Configuration
			//retrieve @bean
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("address2"));
			//System.out.println(context.getBean(Person.class));
			//System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("person5Qualifier"));
			
			//list all beans:
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
		}
				
	}

}
