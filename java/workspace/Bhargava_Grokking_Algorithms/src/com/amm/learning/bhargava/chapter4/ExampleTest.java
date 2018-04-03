package com.amm.learning.bhargava.chapter4;

import com.amm.learning.bhargava.utils.ConvertUtils;

public class ExampleTest {

	public static void test() {
		
		int[] testArray1 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		System.out.println("Initial array: " + ConvertUtils.arrayAsString(testArray1));
		
		QuickSort quickSort = new QuickSort(testArray1);
		quickSort.sort();
		
		System.out.println("Result array: " + ConvertUtils.arrayAsString(quickSort.getArray()));
	}
	
}
