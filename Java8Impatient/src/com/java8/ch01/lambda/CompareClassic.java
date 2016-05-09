package com.java8.ch01.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class CompareClassic {
	public static void main(String[] args) {
		String[] words = {"Hello", "World", "I", "am", "living", "in", "China"};
		Arrays.sort(words, new LengthComparator());
		for(String word : words){
			System.out.println(word);
		}
	}
}

class LengthComparator implements Comparator<String>{

	@Override
	public int compare(String first, String second) {
		return Integer.compare(first.length(), second.length());
	}
	
}