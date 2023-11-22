package br.net.galdino.learnjpaandhibernate.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.galdino.learnjpaandhibernate.model.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
