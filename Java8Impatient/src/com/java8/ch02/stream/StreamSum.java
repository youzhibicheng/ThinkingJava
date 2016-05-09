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

public class StreamSum {

	public static void main(String[] args) {
		String content;
		try {
			content = new String(Files.readAllBytes(Paths.get("src//com//java8//ch02//stream//alice.txt")), StandardCharsets.UTF_8);
			Stream<String> words = Stream.of( content.split("[\\P{L}]"));
			int result = words.reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
			System.out.println( result );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
