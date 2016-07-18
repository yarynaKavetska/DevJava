package core.less22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import core.less20.Person;

public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(array).forEach(System.out::println);
//		print(array, (int elem)->{
//			return true;
//		});
//		print(array, new Filter() {
//			public boolean test(int elem) {
//				return true;
//			}});
		System.out.println();
		Arrays.stream(array).filter(e->e%2==0).forEach(System.out::println);
//		print(array, (elem)->elem%2==0);
//		print(array, new Filter() {
//			public boolean test(int elem) {
//				return elem%2==0;
//			}});
		System.out.println();
		Arrays.stream(array).filter(e->e%3==0).forEach(System.out::println);
//		print(array, elem->elem%3==0);
//		print(array, new Filter() {
//			public boolean test(int elem) {
//				return elem%3==0;
//			}});
		
		List<Person> persons = new ArrayList<>();
		
		List<String> personNames = persons.stream()
				//.map(p->p.getName())
				.map(Person::getName)
				.filter((s)->s.startsWith("A"))
				.collect(Collectors.toList());
		
		List<String> petNames = persons.stream()
				//.sorted(Comparator.comparing(p->p.getAge()).thenComparing(p->p.getName()).reversed())
				.sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed())
				//.map(p->p.getPets())
				.map(Person::getPets)
				//.flatMap(l->l.stream())
				.flatMap(List::stream)
				//.map(p->p.getName())
				.map(Person.Pet::getName)
				.collect(Collectors.toList());
		
		int allCodes = persons.stream()
				//.map(p->p.getPets())
				.map(Person::getPets)
				//.flatMap(l->l.stream())
				.flatMap(List::stream)
				//.map(p->p.getName())
				.map(Person.Pet::getName)
				.flatMapToInt(String::chars)
//				.reduce(0, (acc, elem)->acc+elem);
//				.reduce(0, Main::acc);
				.reduce(0, Integer::sum);
	}
	
	static int acc(int acc, int elem){
		return acc+elem;
	}
	
//	static void print(int[] array, Filter filter){
//		for (int i : array) {
//			if(filter.test(i))
//			System.out.println(i);
//		}
//	}
}
