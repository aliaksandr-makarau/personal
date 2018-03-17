package com.amm.learning.bhargava.chapter1;

public class BinarySearch {

	int[] array;
	int wantedNumber;
	
	public BinarySearch(int[] array, int wantedNumber) {
		this.array = array;
		this.wantedNumber = wantedNumber;
	}
	
	public void setWantedNumber(int wantedNumber) {
		this.wantedNumber = wantedNumber;
	}

	/**
	 * @return 	index of a wanted number in the array;
	 * 			-1 - if the wanted number was not found.
	 */
	public int doSearch() {
		
		int start = 0;
		int end = array.length - 1;
		
		while (start <= end) {
			int middle = start + (end - start) / 2;
			int middleNumber = array[middle];
			
			if (wantedNumber == middleNumber) {
				return middle;
			}
			else if (wantedNumber < middleNumber) {
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		
		return -1;
	}
}
