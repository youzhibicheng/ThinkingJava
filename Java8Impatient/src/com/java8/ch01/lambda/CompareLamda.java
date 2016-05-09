package com.java8.ch01.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class CompareLamda {
	public static void main(String[] args) {
		String[] words = {"Hello", "World", "I", "am", "living", "in", "China"};
		Comparator<String> comp = (String first, String second) -> Integer.compare(first.length(), second.length());
		Arrays.sort(words, comp);
		for(String word : words){
			System.out.println(word);
		}
		
		System.out.println("-------------------------------------------");
		
		String[] words2 = {"Hello", "World", "I", "am", "living", "in", "China"};
		Comparator<String> comp2 = (String first, String second) -> {
				if(first.length() > second.length())
					return 1;
				else if (first.length() < second.length())
					return -1;
				else
					return 0;
		};
		Arrays.sort(words2, comp2);
		for(String word : words2){
			System.out.println(word);
		}
	}
}