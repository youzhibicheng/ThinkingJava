package com.java8.ch01.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class CompareLamda2 {
	public static void main(String[] args) {
		String[] words = {"Hello", "World", "I", "am", "living", "in", "China"};
        //instance::instance_method 
        //class::static_method
        //class::instance_method -> this demo
		// equal to (x,y) -> x.compareToIgnoreCase(y)i
		Arrays.sort(words, String::compareToIgnoreCase);
		for(String word : words){
			System.out.println(word);
		}
	}
}