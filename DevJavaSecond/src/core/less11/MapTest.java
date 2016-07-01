package core.less11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.less7.Season;

public class MapTest {

	private Map<String, String> map = new HashMap<>();
	private SeasonQuote seasonQuote = new SeasonQuote();
	private Map<String, List<String>> mapList = new HashMap<>();
	
	@Before
	public void init(){
		map.put("Ivan", "Manager");
		map.put("Petro", "QA");
		map.put("Mykola", "QC");
		map.put("Sergiy", "Developer");
		
		mapList.put("Ivan", new ArrayList<>());
		mapList.get("Ivan").add("Barsik");
		mapList.get("Ivan").add("Brovko");
		
		mapList.put("Petro", new ArrayList<>());
		mapList.get("Petro").add("Komposter");
		mapList.get("Petro").add("Sharik");
		
		mapList.put("Mykola", new ArrayList<>());
		mapList.get("Petro").add("Murzik");
		
		mapList.put("Sergiy", new ArrayList<>());
	}
	
	@After
	public void clear(){
		map.clear();
	}
	
	@Test
	public void mapListTest(){
		List<String> petNames = new ArrayList<>();
		Iterator<Entry<String, List<String>>> entryIter = mapList.entrySet().iterator();
		while(entryIter.hasNext()){
			Entry<String, List<String>> entry = entryIter.next();
			String owner = entry.getKey();
			Iterator<String> listIter = entry.getValue().iterator();
			while(listIter.hasNext()){
				String petName = listIter.next();
				petNames.add(petName);
			}
		}
		assertEquals(5, petNames.size());
		petNames.clear();
		for(Entry<String, List<String>> entry : mapList.entrySet()){
			String owner = entry.getKey();
			for(String petName : entry.getValue()){
				petNames.add(petName);
			}
		}
		assertEquals(5, petNames.size());
		petNames.clear();
		petNames = mapList.entrySet().stream().map(Entry::getValue)
				.flatMap(List::stream).collect(Collectors.toList());
		assertEquals(5, petNames.size());
		
		petNames = mapList.entrySet().stream().map((entry)->entry.getValue())
				.flatMap((list)->list.stream()).collect(Collectors.toList());
		assertEquals(5, petNames.size());
	}
	
	@Test
	public void getQuote(){
		String actual = seasonQuote.getQuote(Season.WINTER);
		String expected = "Winter is cold";
		assertEquals(expected, actual);
		actual = seasonQuote.getQuote(Season.SUMMER);
		expected = "Summer is hot";
		assertEquals(expected, actual);
		actual = seasonQuote.getQuote(Season.AUTUMN);
		expected = "Autumn is rainy";
		assertEquals(expected, actual);
		actual = seasonQuote.getQuote(Season.SPRING);
		expected = "Spring is shiny";
		assertEquals(expected, actual);
	}
	
	@Test
	public void get(){
		String actual = map.get("Ivan");
		String expected = "Manager";
		assertEquals(expected, actual);
		assertNull(map.get("Manager"));
	}
}
