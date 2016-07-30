package less13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import less12.Person;
import less8.Season;

public class Main {
	static Map<String, List<Person>> persons = new HashMap<>();

	public static void main(String[] args) {
		Season season = Season.WINTER;
		switch (season) {
		case AUTUMN: {
			System.out.println("Autumn is rainy");
			break;
		}
		case SPRING: {
			System.out.println("Spring is green");
			break;
		}
		case SUMMER: {
			System.out.println("Summer is shiny");
			break;
		}
		case WINTER: {
			System.out.println("Winter is cold");
			break;
		}
		default:
			
			break;
		}
		Map<Season, String> map = new HashMap<>();
		map.put(Season.AUTUMN, "Autumn is rainy");
		map.put(Season.SPRING, "Spring is green");
		map.put(Season.SUMMER, "Summer is shiny");
		map.put(Season.WINTER, "Winter is cold");
		System.out.println(map.get(season));
		
		String ingeneer = "Ingeneer";
		persons.put(ingeneer, new ArrayList<>());
		persons.get(ingeneer).add(new Person(25, "Petro"));
		persons.get(ingeneer).add(new Person(35, "Ivan"));
		persons.get(ingeneer).add(new Person(33, "Mykola"));
		String programer = "Programer";
		persons.put(programer, new ArrayList<>());
		persons.get(programer).add(new Person(23, "Petro"));
		persons.get(programer).add(new Person(25, "Sergiy"));
		Set<Entry<String, List<Person>>> set = persons.entrySet();
		Iterator<Entry<String, List<Person>>> entryIter = set.iterator();
		while(entryIter.hasNext()){
			Entry<String, List<Person>> entry = entryIter.next();
			String profesion = entry.getKey();
			List<Person> list = entry.getValue();
			Iterator<Person> personIter = list.iterator();
			while(personIter.hasNext()){
				System.out.println(profesion + " " + personIter.next());
			}
		}
		Set<String> keySet = persons.keySet();
		Collection<List<Person>> listValues = persons.values();
		System.out.println();
		for (Entry<String, List<Person>> entry : set) {
			for(Person person : entry.getValue()){
				System.out.println(entry.getKey() + " " + person);
			}
		}
	}
}
