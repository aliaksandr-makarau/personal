package com.amm.learning.bhargava.chapter4;

public class QuickSort {
	
	private int[] array;
	
	QuickSort(int[] array) {
		this.array = array;
	}

	public int[] getArray() {
		return array;
	}
	
	public void sort() {
		sort(0, array.length - 1);
	}
	
	private void sort(int startIndex, int endIndex) {
		
		if (startIndex == endIndex) {
			return;
		}
		
		int middleIndex = startIndex + (endIndex - startIndex) / 2;
		
		int i = startIndex;
		int j = endIndex;

		while (true) {
			while (array[i] < array[middleIndex]) {
				++i;
			}
			
			while (array[j] > array[middleIndex]) {
				--j;
			}
			
			if (i < j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				if (i == middleIndex) {
					middleIndex = j;
				} else if (j == middleIndex) {
					middleIndex = i;
				}
			} else {
				break;
			}
		}
		
		sort(startIndex, middleIndex);
		sort(middleIndex + 1, endIndex);
	}
}
