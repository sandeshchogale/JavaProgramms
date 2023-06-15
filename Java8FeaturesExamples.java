package com.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8FeaturesExamples {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		
		//1. Lambda Expressions:
		String arrList[] = {"apple","Bob","Tom"};
		Collections.sort(Arrays.asList(arrList));
		Arrays.stream(arrList).forEach(ele -> System.out.print(ele+" "));
		
		System.out.println();
		
		List<String> strList = Arrays.asList("apple","Bob","Tom");
		Collections.sort(strList, (String a, String b) -> a.compareTo(b));
		strList.forEach(ele -> System.out.print(ele+" "));
		
		System.out.println();
		
		//2. Functional Interfaces:
		List<Integer> numList = Arrays.asList(6,3,4,8,7);
		numList.stream()
			.filter(num -> num %2 == 0)
			.sorted()
			.forEach(System.out::println);
		
		System.out.println();
		
		int sum = numList.stream()
					.mapToInt(Integer::intValue)
					.sum();
		System.out.println(sum);
		
		System.out.println();
		
		//3. Stream API:
		List<String> sortedList = strList.stream().sorted().collect(Collectors.toList());
		sortedList.forEach(System.out::print);
		
		System.out.println();
		
		//5. Optional Class:
		Java8FeaturesExamples test = new Java8FeaturesExamples();
		test.setName("Test");
		Optional<String> name = Optional.ofNullable(test.getName());
		String result = name.orElse("Unknown");
		System.out.println(result);
		
		System.out.println();
		
		String[] words = new String[10];
		words[5]="e";
		Optional<String> nullString = Optional.ofNullable(words[5]);
		if(nullString.isPresent()) {
			String word = words[5].toLowerCase().toUpperCase();
			System.out.println(word);
		}else {
			System.out.println("word is null");
		}
		
		//6. Method References:
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		names.forEach(System.out::println);
		
		//7. Date/Time API:
		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate nextWeek = today.plusWeeks(1);
		System.out.println(nextWeek);
	}

}

//4. Default methods in interface

interface MyInterface {
    default void sayHello() {
        System.out.println("Hello, World!");
    }
}

class MyClass implements MyInterface {
    // No need to implement sayHello() since it has a default implementation.
}

//Method reference
class MethodReference2 {  
    public static void ThreadStatus(){  
        System.out.println("Thread is running...");  
    }  
    public static void main(String[] args) {  
        Thread t2=new Thread(MethodReference2::ThreadStatus);  
        t2.start();       
    }  
}  