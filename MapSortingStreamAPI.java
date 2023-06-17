package com.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortingStreamAPI {

	public static void main(String[] args) {
		
		mapSortingExample();
		listDeclaration();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Alice", 25);
		map.put("Bob", 30);
		map.put("Charlie", 20);
		
		System.out.println("sortAscendingMap:  "+sortAscendingMap(map));
		System.out.println("sortDescendingMap: "+sortDescendingMap(map));
		
		LinkedList<Integer> integerLinkedList = new LinkedList<>();
		integerLinkedList.add(5);
		integerLinkedList.add(2);
		integerLinkedList.add(8);
		integerLinkedList.add(1);
		
		System.out.println("sortedIntegerAscendingList: "+sortedIntegerAscendingList(integerLinkedList));
		System.out.println("sortedIntegerDescendingList: "+sortedIntegerDescendingList(integerLinkedList));
		
		LinkedList<String> stringLinkedList = new LinkedList<>();
		stringLinkedList.add("Charlie");
		stringLinkedList.add("Alice");
		stringLinkedList.add("Bob");
		
		System.out.println("sortedStringAscendingList: "+sortedStringAscendingList(stringLinkedList));
		System.out.println("sortedStringDescendingList: "+sortedStringDescendingList(stringLinkedList));
		
	}

	private static Map<String, Integer> sortAscendingMap(Map<String, Integer> map){
		Map<String, Integer> sortedMap =new HashMap<>();
		
		sortedMap = map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue, 
						LinkedHashMap::new));
		
		Map<String, Integer> sortedMapNew = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        LinkedHashMap::new,
                        (result, entry) -> result.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );
		System.out.println("Ascending Order:");
		sortedMapNew.forEach((key, value) -> System.out.print(key + " -> " + value));
		
		return sortedMap;
		
		 
	}
	
	private static Map<String, Integer> sortDescendingMap(Map<String, Integer> map){
		Map<String, Integer> sortedMap =new HashMap<>();
		
		sortedMap = map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, 
						(oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		
		Map<String, Integer> sortedMapNew = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        LinkedHashMap::new,
                        (result, entry) -> result.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );
		System.out.println("Descending Order:");
		sortedMapNew.forEach((key, value) -> System.out.print(key + " -> " + value));
		
		return sortedMap;
	}
	
	private static LinkedList<Integer> sortedIntegerAscendingList(LinkedList<Integer> linkedList) {
		LinkedList<Integer> sortedList = new LinkedList<>();
		
		sortedList =  linkedList.stream()
				.sorted()
				.collect(Collectors.toCollection(LinkedList::new));
		
		return sortedList;
	}
	
	private static LinkedList<Integer> sortedIntegerDescendingList(LinkedList<Integer> linkedList) {
		LinkedList<Integer> sortedList = new LinkedList<>();
		
		sortedList =  linkedList.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedList::new));
		
		return sortedList;
	}
	
	private static LinkedList<String> sortedStringAscendingList(LinkedList<String> linkedList) {
		LinkedList<String> sortedList = new LinkedList<>();
		
		sortedList =  linkedList.stream()
				.sorted()
				.collect(Collectors.toCollection(LinkedList::new));
		
		return sortedList;
	}
	
	private static LinkedList<String> sortedStringDescendingList(LinkedList<String> linkedList) {
		LinkedList<String> sortedList = new LinkedList<>();
		
		sortedList =  linkedList.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedList::new));
		
		return sortedList;
	}
	
	public static void mapSortingExample() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 5);
        map.put("Banana", 2);
        map.put("Orange", 7);
        map.put("Grapes", 3);
        map.put("Mango", 1);

        // Sort in ascending order based on values
        Map<String, Integer> ascendingMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        LinkedHashMap::new,
                        (result, entry) -> result.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );

        System.out.println("Ascending Order:");
        ascendingMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        // Sort in descending order based on values
        Map<String, Integer> descendingMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        LinkedHashMap::new,
                        (result, entry) -> result.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );

        System.out.println("Descending Order:");
        descendingMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
private static void listDeclaration() {
		int[] array = {1,2,3};
    	
    	List<Integer> arrayList = new ArrayList<>();
    	
    	List<Integer> arraysAsList = Arrays.asList(1,2);
    	
    	List<Integer> streamAsList = Stream.of(1,2).collect(Collectors.toList());
    	
    	List<Integer> streamAsList1 = Stream.of(1,2).collect(Collectors.toCollection(ArrayList::new));
    	
    	List<Integer> singletoneList = Collections.singletonList(2);
    	
    	List<Integer> collectionsList = Collections.EMPTY_LIST;
    	Collections.addAll(collectionsList = new ArrayList<Integer>(), 1, 2, 3, 4);
    	
    	List<Integer> listAdd = new ArrayList<Integer>() {{ add(1);add(3); }};
    	
    	List<Integer> llist = new LinkedList<Integer>();
        llist.add(2);llist.add(4);
        
        List<Integer> aList=new ArrayList<Integer>();
        List<Integer> liList=new LinkedList<Integer>();
        List<Integer> stack=new Stack<Integer>();
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
	}
	
}
