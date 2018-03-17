package com.amm.learning.bhargava.chapter1;

public class ExampleTest {

	public static void test() {
		
		int[] testArray1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		
		output(testArray1, 4);
		output(testArray1, 5);
		output(testArray1, 0);
		output(testArray1, 11);
		output(testArray1, 12);
		output(testArray1, 1);
	}
	
	private static void output(int[] array, int number) {
		
		BinarySearch binarySearch = new BinarySearch(array, number);
		
		StringBuilder arrayOutput = new StringBuilder("{");
		
		for (int i = 0; i < array.length; ++i) {
			arrayOutput.append(array[i]);
			
			if (i != array.length - 1) {
				arrayOutput.append(',');
			}
		}
		
		arrayOutput.append("}");
		
		System.out.println("Test array: " + arrayOutput.toString());
		System.out.println("Test wanted number: " + number);
		System.out.println("Result: " + binarySearch.doSearch());
	}
}
