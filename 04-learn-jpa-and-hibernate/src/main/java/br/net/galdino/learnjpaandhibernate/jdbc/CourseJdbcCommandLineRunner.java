package br.net.galdino.learnjpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.net.galdino.learnjpaandhibernate.model.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJdbcRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "name1", "author1"));
		repository.insert(new Course(2, "name2", "author2"));
		repository.insert(new Course(3, "name3", "author3"));
		repository.delete(2l);
		System.out.println(repository.select(1l));
	}

}
