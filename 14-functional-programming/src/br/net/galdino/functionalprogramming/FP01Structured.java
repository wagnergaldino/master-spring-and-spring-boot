package br.net.galdino.functionalprogramming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {

		//List.of available since Java 9 - for Java 8 use Arrays.asList
		printAllNumbersInStructuredList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 5, 7));
		System.out.println("----------------------------------------------------------");
		printEvenNumbersInStructuredList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 5, 7));
		
	}

	private static void printAllNumbersInStructuredList(List<Integer> numbers) {
		for (Integer number : numbers) {
			System.out.println(number);
		}		
	}
	
	private static void printEvenNumbersInStructuredList(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}		
	}

}
