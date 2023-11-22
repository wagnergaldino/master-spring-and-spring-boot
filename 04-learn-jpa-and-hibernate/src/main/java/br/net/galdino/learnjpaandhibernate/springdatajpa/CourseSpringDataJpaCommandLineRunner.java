package br.net.galdino.learnjpaandhibernate.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.net.galdino.learnjpaandhibernate.model.Course;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(7, "name7", "author7"));
		repository.save(new Course(8, "name8", "author8"));
		repository.save(new Course(9, "name9", "author9"));
		
		repository.deleteById(7l);
		
		System.out.println(repository.findById(8l));
		
		System.out.println(repository.findAll());
		
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("author9"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("name8"));
		System.out.println(repository.findByName(""));
	}

}
