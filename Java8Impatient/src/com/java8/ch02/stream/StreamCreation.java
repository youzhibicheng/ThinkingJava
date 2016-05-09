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

public class StreamCreation {

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("src//com//java8//ch02//stream//alice.txt")), StandardCharsets.UTF_8);
			Stream<String> words = Stream.of( content.split("[\\P{L}]"));
			Stream<String> song = Stream.of("gently", "down", "the", "stream");
			Stream<String> empty = Stream.empty();
			
			Stream<String> echos = Stream.generate(() -> "Echos" );
			Stream<Double> randoms = Stream.generate( Math::random);
			
			Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE));
			
			Stream<String> words2 = Pattern.compile("[\\P{L}]").splitAsStream(content);
			
			Stream<String> words3 = Files.lines( Paths.get("src//com//java8//ch02//stream//alice.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
