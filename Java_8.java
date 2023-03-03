package com.array.exercise;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java_8 {

	public static void main(String[] args) {

//find max number in int type array
		System.out.println("-----------------Find the Max.No. in array---------------------");
		int a[] = { 12, 50, 567, 34, 54, 90, 34 };
		int max = Arrays.stream(a).max().getAsInt();
		System.out.println("Maximum number in array is = " + max);
		System.out.println();

//convert integer array into list
		System.out.println("-----------------convert integer array into list---------------------");
		Integer a1[] = { 517, 34, 23, 4856, 98, 90, 189, 12, 1234 };
		List<Integer> l = Arrays.asList(a1);
		System.out.println("Converted Integer type array into list is :" + l);
		System.out.println();

		Optional<String> sq = l.stream().max((i1, i2) -> i1.compareTo(i2)).map(s -> s + "")
				.filter(s -> s.startsWith("1"));
		// System.out.println("*****"+sq);

//Map methode example	
		System.out.println("-----------------Map methode example---------------------");
		List<String> pp = new ArrayList<>();
		pp.add("Ram");
		pp.add("Sham");
		pp.add("Gopal");
		pp.add("Pream");
		List list = pp.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println(list);
		list.stream().forEach(s -> System.out.println(s));
		System.out.println();

// Flat Map methode example	
		System.out.println("-----------------Flat Map methode example---------------------");
		List<String> l1 = Arrays.asList("Pandu", "Dnandu", "Sham");
		List<String> l2 = Arrays.asList("Sham", "Tejai", "Pream");
		List<String> l3 = Arrays.asList("Gopal", "Dhanaji", "Jonh");

		List<List<String>> allList = new ArrayList<List<String>>();
		allList.add(l1);
		allList.add(l2);
		allList.add(l3);

		List<String> totalList = new ArrayList<String>();
		List listm = allList.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
		System.out.println(listm);
		listm.stream().forEach(s -> System.out.println(s));
		System.out.println();

//print array in reverse order using java 8
		System.out.println("-----------------print array in reverse order using java 8---------------------");
		List ooo = Arrays.stream(a1).sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(ooo);
//		list.stream().forEach(s->System.out.println(s));
		System.out.println();

//find 2nd max no in array using java 8
		System.out.println("-----------------find 2nd max no in array using java 8---------------------");
		Integer xxx = Arrays.stream(a1).sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println("2 nd max no :" + xxx);
		// OR
		Integer xxxx = Arrays.stream(a1).sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
		System.out.println("3 nd max no :" + xxxx);
		System.out.println();

//Count of duplicate in List
		System.out.println("-----------------Count occerance of each element---------------------");
		List<Integer> count = Arrays.asList(12, 13, 12, 13, 3, 45, 67, 98, 34);
		LinkedHashMap<Integer, Long> counting = count.stream()
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
		System.out.println(counting);
		System.out.println();

		System.out.println("-----------------number starts with 1---------------------");
		List<Integer> findNoStartWith = Arrays.asList(1, 13, 45, 7, 52, 14, 64, 14, 660, 76, 1, 13);
		List<String> vinit = findNoStartWith.stream().map(s -> s + "").filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(vinit);

		System.out.println("-----------------Print duplicate in list---------------------");
		List<Integer> list1 = Arrays.asList(1, 2, 1, 2, 36, 74, 875, 35, 74, 9, 3, 16);
		Set<Integer> se = new HashSet<>();
		List<Integer> PrintedDuplicate = list1.stream().filter(n -> !se.add(n)).collect(Collectors.toList());
		System.out.println(PrintedDuplicate);
		System.out.println();

		System.out.println("-----------------Find First Element---------------------");
		List<Integer> listt = Arrays.asList(1, 3, 2, 54, 68, 48);
		Integer i = listt.stream().findFirst().get();
		System.out.println(i);
		System.out.println();

		System.out.println("-----------------Max Number---------------------");
		List<Integer> list3 = Arrays.asList(1, 2, 24, 4, 68, 90, 2446, 954, 24);
		Integer maxNo = list3.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(maxNo);
		System.out.println();

		System.out.println("-----------------first non-repeated character---------------------");
		String s = "Java is a programming laungauge";
		Character result = s.chars().mapToObj(x -> Character.toLowerCase(Character.valueOf((char) x)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);
		System.out.println();

		System.out.println("-----------------first repeated character---------------------");
		String input = "Java Hungry Blog Alive is Awesome";
		Character result1 = input.chars().mapToObj(y -> Character.toLowerCase(Character.valueOf((char) y)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result1);
		System.out.println();

		System.out.println("-----------------Print vovels in String---------------------");
		String string = "vint salokhe";
		String vovels = string.replaceAll("[^a,e,i,o,u]", "");
		System.out.println(vovels);
		System.out.println(vovels.length());
		System.out.println();
		
		System.out.println("-------------------Reversed String-----------------------");
		String str = "My Name Is Mukund";
		String reversedString = Stream.of(str).map(p-> new StringBuilder(p).reverse()).collect(Collectors.joining());
		System.out.println(reversedString);
		System.out.println(reversedString.length());
		System.out.println();
	
	}
}
