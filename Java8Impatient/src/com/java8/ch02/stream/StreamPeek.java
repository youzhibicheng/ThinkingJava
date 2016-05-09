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

public class StreamPeek {

	public static void main(String[] args) {
		Object[] powers = Stream.iterate(1.0, p -> p * 2)
				.peek(e -> System.out.println("Fetching " + e))
				.limit(20)
				.toArray();
		for (Object power : powers)
			System.out.println(power);
	}
}
