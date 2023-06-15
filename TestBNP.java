package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestBNP {

	public static void main(String args[]) {
		/*
		 * String sentence = "This is a sentence."; String[] words =
		 * sentence.split("\\s+"); Arrays.stream(words) .forEach(System.out::println);
		 * System.out.println(words.length);
		 */
		
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("test");
		list.add("");
		list.add("test1");
		
		list.removeIf(String::isEmpty);
		
		List<String> emptyList = list.stream()
		.filter(String::isEmpty)
		.collect(Collectors.toList());
		
		String result = list.stream()
				.map(String::toUpperCase)
				.collect(Collectors.joining(", "));
		
		System.out.println(result);
		
		createFile();
		writeFile();
		readFile();
	
	}
	
	private static void createFile() {
		try {
			 File file = new File("D:\\test.txt");
	            if (file.createNewFile()) {
	                System.out.println("File created: " + file.getName());
	            } else {
	                System.out.println("File already exists.");
	            }
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private static void writeFile() {
		try (FileWriter writer = new FileWriter("D:\\test.txt")) {
			writer.write("test");
			System.out.println("Successfully wrote to the file.");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void readFile() {
		StringBuilder content= new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:\\test.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				content.append(line);
			}
			System.out.println(content);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void writeFileFile() {
		
	}
	
	
}
