package br.net.galdino.learnjpaandhibernate.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.net.galdino.learnjpaandhibernate.model.Course;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(4, "name4", "author4"));
		repository.insert(new Course(5, "name5", "author5"));
		repository.insert(new Course(6, "name6", "author6"));
		repository.delete(5l);
		System.out.println(repository.findById(4l));
	}

}
