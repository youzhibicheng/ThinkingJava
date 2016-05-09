package com.java8.ch02.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamMap2 {
	public static void main(String[] args) {
		String words = "your boat is sitting on the river";
		
		Stream<Character> sc = characterStream(words);
//		Stream<Character> ssc = words.map();
	}

	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<Character>();
		for (char c : s.toCharArray())
			result.add(c);
		return result.stream();
	}

}
