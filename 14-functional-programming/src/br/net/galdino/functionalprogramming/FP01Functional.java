package br.net.galdino.functionalprogramming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		//List.of available since Java 9 - for Java 8 use Arrays.asList
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 5, 7);
		
		List<String> courses = List.of("Spring Boot", "Spring", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
		
		printAllNumbersInFunctionalList(numbers);
		System.out.println("----------------------------------------------------------");
		printEvenNumbersInFunctionalList(numbers);
		System.out.println("----------------------------------------------------------");
		printOddNumbersInFunctionalList(numbers);
		System.out.println("----------------------------------------------------------");
		printEachCourseIndividually(courses);	
		System.out.println("----------------------------------------------------------");
		printCourseContainingSpring(courses);	
		System.out.println("----------------------------------------------------------");
		printCourseLenghtBiggerThanFour(courses);
		System.out.println("----------------------------------------------------------");
		printSquaresOfEvenNumbersInFunctionalList(numbers);
		System.out.println("----------------------------------------------------------");
		printCubeOfOddNumbersInFunctionalList(numbers);
		System.out.println("----------------------------------------------------------");
		printLenghtOfEveryCourse(courses);
	}
	
//	private static void print(int number) {
//		System.out.println(number);
//	}   https://howtodoinjava.com/java/stream/debugging-java-streams/

	private static void printAllNumbersInFunctionalList(List<Integer> numbers) {		
		
		//How to Loop - Functional way
		//The stream loops over the list of elements one by one
		numbers.stream()
			//.forEach(FP01Functional::print); // FP01Functional::print - Method reference - static method
			.forEach(System.out::println); // System.out::println - println static method from System class
	}

//	private static boolean isEven(int number) {
//		return number %2 == 0;
//	}
	
	private static void printEvenNumbersInFunctionalList(List<Integer> numbers) {			
		numbers.stream()
			//.filter(FP01Functional::isEven)
			.filter(number -> number % 2 == 0)
			.forEach(System.out::println);
	}
	
	private static void printSquaresOfEvenNumbersInFunctionalList(List<Integer> numbers) {			
		numbers.stream()
			.filter(number -> number % 2 == 0)
			.map(number -> number * number)
			.forEach(System.out::println);
	}
	
	private static void printOddNumbersInFunctionalList(List<Integer> numbers) {		
		numbers.stream()
			//.filter(FP01Functional::isEven)
			.filter(number -> number % 2 == 1)
			.forEach(System.out::println);
	}
	
	private static void printCubeOfOddNumbersInFunctionalList(List<Integer> numbers) {		
		numbers.stream()
			.filter(number -> number % 2 == 1)
			.map(number -> number * number * number)
			.forEach(System.out::println);
	}
	
	private static void printEachCourseIndividually(List<String> courses) {		
		courses.stream()
			.forEach(System.out::println);
	}
	
	private static void printCourseContainingSpring(List<String> courses) {		
		courses.stream()
			.filter(course -> course.contains("Spring"))
			.forEach(System.out::println);
	}
	
	private static void printCourseLenghtBiggerThanFour(List<String> courses) {		
		courses.stream()
			.filter(course -> course.length() > 4)
			.forEach(System.out::println);
	}
	
	private static void printLenghtOfEveryCourse(List<String> courses) {		
		courses.stream()
			.map(course -> course.length())
			.forEach(System.out::println);
	}

}
