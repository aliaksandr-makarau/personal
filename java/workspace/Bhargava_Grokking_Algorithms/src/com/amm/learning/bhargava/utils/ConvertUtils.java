package com.amm.learning.bhargava.utils;

public class ConvertUtils {

	public static StringBuilder arrayAsString(int[] array) {

		StringBuilder arrayOutput = new StringBuilder("{");
		
		for (int i = 0; i < array.length; ++i) {
			arrayOutput.append(array[i]);
			
			if (i != array.length - 1) {
				arrayOutput.append(',');
			}
		}
		
		arrayOutput.append("}");
		
		return arrayOutput;
	}
	
}
