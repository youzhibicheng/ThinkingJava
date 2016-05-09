package com.java8.ch02.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadBookParallelStream {

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("src//com//java8//ch02//stream//alice.txt")), StandardCharsets.UTF_8);
//			System.out.println(content);
			List<String> words = Arrays.asList( content.split("[\\P{L}]") );
			long count = words.stream().filter( w -> w.length()>12).count();
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
