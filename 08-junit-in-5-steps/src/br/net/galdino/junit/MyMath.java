package br.net.galdino.junit;

public class MyMath {

	/*
	 * public static void main(String[] args) { System.out.println(calculateSum(new
	 * int[]{1, 2, 3})); }
	 */
	
	//public static int calculateSum(int[] numbers) {
	public int calculateSum(int[] numbers) {
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		return sum;
	}

}
