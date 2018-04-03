package com.amm.learning.bhargava.chapter1;

import com.amm.learning.bhargava.utils.ConvertUtils;

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
		
		System.out.println("Test array: " + ConvertUtils.arrayAsString(array));
		System.out.println("Test wanted number: " + number);
		System.out.println("Result: " + binarySearch.doSearch());
	}
	
}
