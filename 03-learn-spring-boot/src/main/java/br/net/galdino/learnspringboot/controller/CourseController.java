package br.net.galdino.learnspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.galdino.learnspringboot.model.Course;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "name1", "author1"),
				new Course(2, "name2", "author2"),
				new Course(3, "name3", "author3")
				);
	}

}
