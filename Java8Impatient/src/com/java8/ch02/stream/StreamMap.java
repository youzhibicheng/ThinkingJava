package com.java8.ch02.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamMap {

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("src//com//java8//ch02//stream//alice.txt")), StandardCharsets.UTF_8);
			Stream<String> words = Stream.of( content.split("[\\P{L}]"));

			Stream<String> lowercaseWords = words.map( String::toLowerCase );
			Stream<Character> firstChars = words.map( s -> s.charAt(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
